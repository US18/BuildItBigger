package just.android.uplabdhisingh.jokesandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity
{

    TextView showJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        showJokeTextView = (TextView) findViewById(R.id.tv_show_joke);


        Intent intentFromFragment = getIntent();
        String jokeFromFragment = intentFromFragment.getStringExtra("JOKE");

        showJokeTextView.setText(jokeFromFragment);
    }
}
