package com.codepath.apps.MyTwitterApp.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.MyTwitterApp.R;
import com.codepath.apps.MyTwitterApp.adapters.TweetsArrayAdapter;
import com.codepath.apps.MyTwitterApp.models.Tweet;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by East Coast Pawn on 8/8/2017.
 */

public class TweetsListFragments extends Fragment {


    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragments_tweets_list,parent,false);
        lvTweets = (ListView) v.findViewById(R.id.LvTweets);
        lvTweets.setAdapter(aTweets);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tweets = new ArrayList<>();
        aTweets = new TweetsArrayAdapter(getActivity(), tweets);
    }

    public void addAll(List<Tweet> tweets){
        aTweets.addAll(tweets);
        aTweets.notifyDataSetChanged();
    }
}
