package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jasensanders.jokedisplay.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Jasen Sanders on 5/22/2016.
 * AsyncTask that calls the Google Cloud engine API and retrieves the result string.
 * This Task also handles progressbar display. Pass null To constructor to test
 * (i.e. new EndpointsAsyncTask(null) )
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private Activity mActivity;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(Activity frag){
        super();
        //If this is a test, then skip the progressbar
        if(frag != null) {
            mActivity = frag;
            mProgressBar = (ProgressBar) mActivity.findViewById(R.id.ProgressBarWait);
        }

    }


    @Override
    protected void onPreExecute() {
        //Todo Put a Spinner progressbar in
        super.onPreExecute();
        if(mProgressBar != null) {
            mProgressBar.setIndeterminate(true);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //.setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    //My local machine IP address for testing
                    .setRootUrl("http://10.0.0.3:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {

            return myApiService.sayHi(name).execute().getData();

        } catch (IOException e) {

            Log.e("AsyncTask IO Issue", e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        //Stop the progressbar
        if(mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        //Start the JokeActivity
        if(result != null && mActivity != null) {
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE_KEY, result);
            context.startActivity(intent);
        }


    }
}
