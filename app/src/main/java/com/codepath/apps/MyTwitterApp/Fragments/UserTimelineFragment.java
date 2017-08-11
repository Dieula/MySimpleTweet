package com.codepath.apps.MyTwitterApp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.MyTwitterApp.models.Tweet;
import com.codepath.apps.MyTwitterApp.utils.TwitterApplication;
import com.codepath.apps.MyTwitterApp.utils.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by East Coast Pawn on 8/10/2017.
 */

public class UserTimelineFragment extends TweetsListFragments {
    private TwitterClient client;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        populateTimeline();
    }

    public static UserTimelineFragment newInstance(String screen_name) {
        UserTimelineFragment userFragment = new UserTimelineFragment();
        Bundle args = new Bundle();
        args.putString("screen_name", screen_name);
        userFragment.setArguments(args);
        return userFragment;
    }

    private void populateTimeline() {
        String screenName = getArguments().getString("screen_nane");
        client.getUserTimeline(screenName, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                addAll(Tweet.fromJSONArray(json));
                //super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonError) {
                Log.d("DEBUG", jsonError.toString());
            }
        });
    }
}
