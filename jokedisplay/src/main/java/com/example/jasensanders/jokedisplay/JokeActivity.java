package com.example.jasensanders.jokedisplay;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class JokeActivity extends ActionBarActivity {
    //Key for intent extra data passed in.
    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
