package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * MainActivity tests to test Google Cloud Endpoints Async Task and Api
 * Created by Jasen Sanders on 5/22/2016.
 */

public class MainActivityTests extends AndroidTestCase  {

    private static final String LOG_TAG = MainActivityTests.class.getSimpleName();

    final Activity testAct = null;
    final String test = "test";

    public void testAsyncTask() throws Throwable{
        MainActivity mActivity = new MainActivity();

        EndpointsAsyncTask tester = new EndpointsAsyncTask(testAct);
        String right;


        //Execute the task.
        tester.execute(new Pair<Context, String>(mActivity, test));
        //Get the result String.
        right = tester.get();

        //The String has been loaded.
        assertNotNull(right);
        //The String is not empty.
        assertTrue(!right.isEmpty());
        //The string ends with an ! as the jokebuilder defines, therefore it is not an error message.
        assertTrue(right.endsWith("!"));
        //Shutdown Activity
        mActivity.finish();

        //Log it cause its awesome baby!
        Log.v(LOG_TAG + ": tester.get contains: ", right);

    }

    public void testMyApiEndpoint() throws Throwable{
        MainActivity mActivity = new MainActivity();

        EndpointsAsyncTask tester = new EndpointsAsyncTask(testAct);
        String right;

        //Execute the task.
        tester.execute(new Pair<Context, String>(mActivity,test));
        //Get the result String.
        right = tester.get();

        //My Endpoint prepends "Hi, " string to response
        assertTrue(right.startsWith("Hi "));

        //My Endpoint prepends string passed in, into output response
        assertTrue(right.startsWith("Hi test, "));
        //Shutdown Activity
        mActivity.finish();
    }
}
