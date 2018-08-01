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

import java.util.ArrayList;

import just.android.uplabdhisingh.javajokeslib.Jokes;
import just.android.uplabdhisingh.jokesandroidlib.ShowJokeActivity;

public class FirstFragment extends Fragment implements JokesReceivedInterface
{
    private int counter = 0;

    Button tellJokeButton;

    private ArrayList<String> jokes_list = new ArrayList<>();

    String joke = Jokes.fetchJokes();

    public FirstFragment()
    {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        tellJokeButton = root.findViewById(R.id.btn_tell_joke);
        tellJokeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showJoke();
            }
        });

        fetchAllJokes();

        return root;
    }

    private void fetchAllJokes()
    {
        new AsyncTaskClass().execute(this);
    }

    public void showJoke()
    {
        String joke;
        if(counter != jokes_list.size())
        {
            joke = jokes_list.get(counter);
            counter++;
        } else {
            counter = 0;
            joke = jokes_list.get(counter);
            counter++;
        }
        Intent jokeIntent = new Intent(getActivity(), ShowJokeActivity.class);
        jokeIntent.putExtra("JOKE", joke);
        startActivity(jokeIntent);
    }

    @Override
    public void jokesReceived(String jokes)
    {
        jokes=joke;
        jokes_list.add(jokes);
    }

}
