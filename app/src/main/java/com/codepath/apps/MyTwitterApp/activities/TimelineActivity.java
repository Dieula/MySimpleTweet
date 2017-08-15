package com.codepath.apps.MyTwitterApp.activities;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.MyTwitterApp.Fragments.HomeTimelineFragment;
import com.codepath.apps.MyTwitterApp.Fragments.MentionsTimelineFragment;
import com.codepath.apps.MyTwitterApp.R;

public class TimelineActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        // Get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        //set the viewpager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
        //Find the slinding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(vpPager);
         
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    public void onProfileView(MenuItem mi){
        Intent i = new Intent (this, ProfileActivity.class);
        startActivity(i);

    }

    public  class TweetsPagerAdapter extends FragmentPagerAdapter
    {
        private String tabTitles[] = {"Home" , "Mentions"};

        public TweetsPagerAdapter(FragmentManager fm){
            super(fm);
        }


      public Fragment getItem(int position){
            if (position == 0)
            {
                return  new HomeTimelineFragment();
            }
            else if (position == 1)
            {
                return new MentionsTimelineFragment();
            }
            else
            {
                return null;
            }
        }
        public CharSequence getPageTitle(int position)

        {
            return tabTitles[position];
        }
        public int getCount()

        {
            return tabTitles.length;
        }
    }
}