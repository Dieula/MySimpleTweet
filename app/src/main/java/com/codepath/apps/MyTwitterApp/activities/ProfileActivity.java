package com.codepath.apps.MyTwitterApp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.MyTwitterApp.Fragments.UserTimelineFragment;
import com.codepath.apps.MyTwitterApp.R;
import com.codepath.apps.MyTwitterApp.models.User;
import com.codepath.apps.MyTwitterApp.utils.TwitterApplication;
import com.codepath.apps.MyTwitterApp.utils.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ProfileActivity extends AppCompatActivity {
    TwitterClient client;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        client = TwitterApplication.getRestClient();
        client.getUserInfo(new JsonHttpResponseHandler(){
                               @Override
                               public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                  user = user.fromJSON(response);


                                getSupportActionBar().setTitle("@" + user.getScreenName().toString());
                                  populateProfileHeader(user);
                               }
                           });
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        String screenName = getIntent().getStringExtra("screen_name");
        if (savedInstanceState == null) {

            UserTimelineFragment fragmentUserTimeline = UserTimelineFragment.newInstance(screenName);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContainer, fragmentUserTimeline);
            ft.commit();
        }

    }

    private void populateProfileHeader(User user){
        TextView tvName = (TextView) findViewById(R.id.tvUserNameProf);
        TextView tvTagline = (TextView) findViewById(R.id.tvTagLineProf);
        TextView tvFollowers = (TextView) findViewById(R.id.tvFollowers);
        TextView tvFollowing = (TextView) findViewById(R.id.tvFollowing);
        ImageView ivProfileImage = (ImageView) findViewById(R.id.ivProfileImageProf);
        tvName.setText(user.getName());
        tvTagline.setText(user.getTagline());
        tvFollowers.setText(user.getFollowersCount() + "Following");
        tvFollowing.setText(user.getFriendsCount() + "Followers");
        Picasso.with(this).load(user.getProfileImageUrl()).into(ivProfileImage);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
    return super.onOptionsItemSelected(item);
    }

}


