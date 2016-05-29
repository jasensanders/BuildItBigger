package com.example.jasensanders.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeActivityFragment extends Fragment {
    private static final String LOG_TAG = JokeActivityFragment.class.getSimpleName();


    public JokeActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke_activity, container, false);

        //Retrieve data passed in, if any.
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);

        //Log all the things.
        Log.v(LOG_TAG, "Android Library input: " + joke);

        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_textview);
        //Verify input and post to view
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;
    }


}





