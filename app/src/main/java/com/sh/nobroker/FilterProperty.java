package com.sh.nobroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.HashMap;


public class FilterProperty extends AppCompatActivity {



    private FilterPropertyUIController uiController;

    protected HashMap<Integer,String> filterMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_property);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateFilterMap();

        uiController = new FilterPropertyUIController(this);

        uiController.initResource();

    }

    void populateFilterMap()
    {
        filterMap.clear();
        filterMap.put(R.id.tb_rk1,"RK1");
        filterMap.put(R.id.tb_bhk1,"BHK1");
        filterMap.put(R.id.tb_bhk2,"BHK2");
        filterMap.put(R.id.tb_bhk3,"BHK3");
        filterMap.put(R.id.tb_bhk4,"BHK4");
        filterMap.put(R.id.tb_bhk4_plus,"BHK4PLUS");
        filterMap.put(R.id.apartment,"AP");
        filterMap.put(R.id.independent_house_villa,"IH");
        filterMap.put(R.id.independent_floor_builder,"IF");
        filterMap.put(R.id.semi,"SEMI_FURNISHED");
        filterMap.put(R.id.full,"FULLY_FURNISHED");
        filterMap.put(R.id.none_furnished,"NOT_FURNISHED");

    }



}
