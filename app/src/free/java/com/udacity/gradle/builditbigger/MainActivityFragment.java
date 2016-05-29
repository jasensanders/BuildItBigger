package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * The MainActivity fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        /**The Full-Screen Interstitial Ad setup */
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.intersittal_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                startJokeActivity();
            }
        });
        requestNewInterstitial();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        /**The banner Ads Setup */
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("ECF8814A2889BB1528CE0F6E1BCFA7ED")  //My GS3 Test Phone
                .build();
        mAdView.loadAd(adRequest);

        return root;
    }

    public void launchJokeActivity(){

        //If the Interstitial Ad is loaded, then show it
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //Otherwise just Start the EndpointsAsyncTask.
            startJokeActivity();
        }
    }

    private void startJokeActivity(){

        EndpointsAsyncTask cloudJoke = new EndpointsAsyncTask(getActivity());
        cloudJoke.execute(new Pair<Context, String>(getContext(), " "));

    }

    private void requestNewInterstitial() {

        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("ECF8814A2889BB1528CE0F6E1BCFA7ED")
                //.addTestDevice("A0233DC1F99F38BB")  //My GS3 Test Phone
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


}

