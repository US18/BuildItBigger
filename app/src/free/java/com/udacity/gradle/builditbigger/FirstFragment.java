package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import just.android.uplabdhisingh.jokesandroidlib.ShowJokeActivity;

public class FirstFragment extends Fragment implements JokesReceivedInterface
{

    private String mJoke;

    Button tellJokeButton;
    AdView adView_fragment;

    public FirstFragment()
    {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        adView_fragment = root.findViewById(R.id.adView_free);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView_fragment.loadAd(adRequest);

        tellJokeButton = root.findViewById(R.id.btn_tell_joke);

        tellJokeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showJoke();
            }
        });

        return root;
    }

    public void showJoke()
    {
        new AsyncTaskClass().execute(this);
    }

    @Override
    public void jokesReceived(String joke)
    {
        mJoke=joke;
        Intent intent = new Intent(getActivity(),ShowJokeActivity.class);
        intent.putExtra("JOKE",mJoke);
        startActivity(intent);
    }
}
