package com.codepath.apps.MySimpleTweet.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by East Coast Pawn on 8/3/2017.
 */

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    private long uid;
    private String ScreenName;
    private String profileImageUrl;

    public static User fromJSON(JSONObject json){
       User u = new User();
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.ScreenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        return  u;
    }

}
