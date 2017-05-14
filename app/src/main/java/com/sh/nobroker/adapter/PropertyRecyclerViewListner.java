package com.sh.nobroker.adapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.sh.nobroker.MainActivity;

/**
 * Created by shanaulhaque on 13/05/17.
 */

public class PropertyRecyclerViewListner extends RecyclerView.OnScrollListener {

    private boolean userScrolled = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    MainActivity activity;
    LinearLayoutManager mLayoutManager;


    public  PropertyRecyclerViewListner(MainActivity activity, LinearLayoutManager layoutManager){
        this.activity = activity;
        this.mLayoutManager = layoutManager;
    }



    @Override
    public void onScrollStateChanged(RecyclerView recyclerView,
                                     int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
            userScrolled = true;
        }

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx,
                           int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount = mLayoutManager.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
        if (userScrolled && (visibleItemCount + pastVisiblesItems) == totalItemCount) {
            userScrolled = false;
            activity.updateList();
        }

    }
}



