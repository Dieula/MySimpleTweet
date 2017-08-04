package com.codepath.apps.MySimpleTweet;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
     client = TwitterApplication.getRestClient();
        populateTimeline();
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //setSupportActionBar(toolbar);


    }

    private void populateTimeline()
    {
        client.getHomeTimeline(new JsonHttpResponseHandler()
        {
            public void onSuccess(int statusCode, Header[] headers, JSONArray json)
            {
                Log.d("DEBUG", json.toString());
                // Load json array into model classes
            }


            public void onFaillure(int statusCode, Header[] headers, JSONObject errorResponse)
            {
                Log.d("DEBUG", errorResponse.toString());
            }
       });

}
}