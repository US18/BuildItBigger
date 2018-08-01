package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class AsyncTaskClass extends AsyncTask<JokesReceivedInterface,Void,String>
{

    private MyApi api = null;
    private JokesReceivedInterface jokesReceivedListener;

    @Override
    protected void onPostExecute(String s)
    {
        jokesReceivedListener.jokesReceived(s);
    }

    @Override
    protected String doInBackground(JokesReceivedInterface... jokesReceivedInterfaces)
    {
        if (api == null)
        {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer()
                    {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException
                        {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            api = builder.build();
        }
        jokesReceivedListener = jokesReceivedInterfaces[0];
        try
        {
            return api.sayHi("Dear! \n This is my First Joke!!! \n You are in free trial version.").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
