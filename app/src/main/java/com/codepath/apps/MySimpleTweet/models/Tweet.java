package com.codepath.apps.MySimpleTweet.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by East Coast Pawn on 8/3/2017.
 */

public class Tweet {
    private String body;
    private  long uid;
    private String createdAt;
    private User user;

    public User getUser() {
        return user;
    }


    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet=new Tweet();
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        return  tweet;
    }
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray)
    {
     ArrayList<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++)
        {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if (tweet != null)
                {
                tweets.add(tweet);
                }
            }catch (JSONException e)
            {
                e.printStackTrace();
                continue;
            }
        }
    return tweets;
}
}