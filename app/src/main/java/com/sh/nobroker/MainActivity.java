package com.sh.nobroker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.sh.model.AppModel;
import com.sh.model.Property;
import com.sh.nobroker.adapter.PropertyAdapter;
import com.sh.nobroker.adapter.PropertyRecyclerViewListner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IAsyncTask {


    private static final String TAG = MainActivity.class.getSimpleName();

    private GetPropertyDetails getPropertyDetails;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private PropertyRecyclerViewListner viewListner;
    private RelativeLayout bottomLayout;
    private FloatingActionButton filterFab;
    private Context context;

    private AppModel appModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        appModel = AppModel.getInstance(this);
        appModel.loadConfiguration();

        mRecyclerView = (RecyclerView) findViewById(R.id.property_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        viewListner = new PropertyRecyclerViewListner(this, mLayoutManager);

        mRecyclerView.addOnScrollListener(viewListner);

        mAdapter = new PropertyAdapter(appModel.getPropertyListToShow());
        mRecyclerView.setAdapter(mAdapter);

        bottomLayout = (RelativeLayout) findViewById(R.id.loading_recyclerView);

        filterFab = (FloatingActionButton) findViewById(R.id.filter_fab);
        filterFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FilterProperty.class);
                startActivityForResult(i, 0);
                overridePendingTransition(R.anim.slide_up, R.anim.do_nothing);

            }
        });

        updateList();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void updateList() {
        bottomLayout.setVisibility(View.VISIBLE);
        String url = String.format("http://www.nobroker.in/api/v1/property/filter/region/ChIJLfyY2E4UrjsRVq4AjI7zgRY/?lat_lng=12.9279232,77.6271078&rent=0,500000&travelTime=30&pageNo=%d", appModel.getPageNumber());
        getPropertyDetails = new GetPropertyDetails(this);
        getPropertyDetails.execute(url);

    }


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void postExecute() {
        addFilter();
        bottomLayout.setVisibility(View.GONE);
        mAdapter.notifyDataSetChanged();
    }


    private ArrayList<Property> properties = new ArrayList<>();

    private void addFilter() {
        properties.clear();
        if (appModel.getFilterApplied()) {
            for (Property property : appModel.getPropertyList()) {
                Boolean isFulfilledAllCondition = true;
                if (appModel.getBoolType()) {
                    if (appModel.getType().contains(property.getType())) {
                        isFulfilledAllCondition &= true;
                    } else
                        isFulfilledAllCondition &= false;
                }
                if (appModel.getBoolBuildingType()) {
                    if (appModel.getBuildingType().contains(property.getBuildingType())) {
                        isFulfilledAllCondition &= true;
                    } else
                        isFulfilledAllCondition &= false;
                }
                if (appModel.getBoolFurnishing()) {
                    if (appModel.getFurnishing().contains(property.getFurnishing())) {
                        isFulfilledAllCondition &= true;
                    } else
                        isFulfilledAllCondition &= false;
                }

                if (isFulfilledAllCondition)
                    properties.add(property);

            }
            appModel.getPropertyListToShow().addAll(properties);
        } else {
            appModel.getPropertyListToShow().addAll(appModel.getPropertyList());
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            updateList();
        }
    }
}

