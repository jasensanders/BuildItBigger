package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The MainActivity fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {



    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        return root;
    }

    public void launchJokeActivity(){

        //Just Start the EndpointsAsyncTask.
        startJokeActivity();

    }

    private void startJokeActivity(){

        EndpointsAsyncTask cloudJoke = new EndpointsAsyncTask(getActivity());
        cloudJoke.execute(new Pair<Context, String>(getContext(), " "));

    }


}

