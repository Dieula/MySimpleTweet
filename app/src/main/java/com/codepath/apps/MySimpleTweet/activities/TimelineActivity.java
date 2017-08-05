package com.codepath.apps.MySimpleTweet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.codepath.apps.MySimpleTweet.R;
import com.codepath.apps.MySimpleTweet.adapters.TweetsArrayAdapter;
import com.codepath.apps.MySimpleTweet.utils.TwitterApplication;
import com.codepath.apps.MySimpleTweet.utils.TwitterClient;
import com.codepath.apps.MySimpleTweet.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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
        lvTweets = (ListView) findViewById(R.id.LvTweets);
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
     client.getHomeTimeline(new JsonHttpResponseHandler(){
         @Override
         public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray json) {
            aTweets.addAll(Tweet.fromJSONArray(json));
             Log.d("DEBUG", aTweets.toString());
             //super.onSuccess(statusCode, headers, response);
         }

         @Override
         public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, JSONObject jsonError) {
            Log.d("DEBUG", jsonError.toString());
         }
     });


}
}