package com.codepath.apps.MySimpleTweet;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.codepath.apps.MySimpleTweet.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.entity.mime.Header;

import static com.loopj.android.http.AsyncHttpClient.log;

public class TimelineActivity extends AppCompatActivity
{
  //  private TwitterClient client;
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;


    private TwitterClient client;

    public TimelineActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        lvTweets = (ListView) findViewById(R.id.IvTweets);
        tweets = new ArrayList<>();
        aTweets = new TweetsArrayAdapter(this, tweets);
        lvTweets.setAdapter(aTweets);
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
                aTweets.addAll(Tweet.fromJSONArray(json));
               log.d("DEBUG", aTweets.toString());
            }


            public void onFaillure(int statusCode, Header[] headers, JSONObject errorResponse)
            {
                Log.d("DEBUG", errorResponse.toString());
            }
       });

}
}