package com.codepath.apps.MySimpleTweet.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by East Coast Pawn on 8/3/2017.
 */

public class Tweet {
    private String body;
    private  long uid;
    private String createdAt;

    public User getUser() {
        return user;
    }

    private User user;
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
}
