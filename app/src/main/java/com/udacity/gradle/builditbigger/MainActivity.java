package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchJokeActivity(View view) {
        //Below is code for the Java Library running locally
//        Intent intent = new Intent(this, JokeActivity.class);
//        JokeBuilder jokeSource = new JokeBuilder();
//        String joke = jokeSource.randomJoke();
//        Log.v(LOG_TAG, joke);
//        intent.putExtra(JokeActivity.JOKE_KEY, joke);
//        startActivity(intent);

        //Below is code to launch the Endpoints AsyncTask from the fragment.
        FragmentManager fm = getSupportFragmentManager();
        MainActivityFragment fragment = (MainActivityFragment)fm.findFragmentById(R.id.fragment);
        fragment.launchJokeActivity();
    }




}
