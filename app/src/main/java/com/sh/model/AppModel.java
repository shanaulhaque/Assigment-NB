package com.sh.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by shanaulhaque on 12/05/17.
 */

public class AppModel {

    private final static String TAG = AppModel.class.getSimpleName();


    private  ArrayList<Property> propertyList = new ArrayList<>();
    private  ArrayList<Property> propertyListToShow = new ArrayList<>();

    public Integer getPageNumber() {
        pageNumber++;
        return pageNumber;
    }


    //Filter Details
    private HashSet<String> type = new HashSet<>();
    private HashSet<String> buildingType = new HashSet<>();
    private HashSet<String> furnishing = new HashSet<>();

    //Filter flag
    private Boolean boolType = false;
    private Boolean boolBuildingType = false;
    private Boolean boolFurnishing = false;

    private Boolean isFilterApplied = false;




    private Integer pageNumber = 0;

    private static AppModel appModel;
    private Activity mActivity;

    public static AppModel getInstance(Activity activity){
        if(appModel == null){
            appModel = new AppModel(activity);
        }
        appModel.mActivity = activity;
        return appModel;
    }
    private AppModel(Activity activity) {

        this.mActivity = activity;
    }

    public void loadConfiguration(){
        propertyList.clear();
        propertyListToShow.clear();
        pageNumber = 0;
        type.clear();
        buildingType.clear();
        furnishing.clear();
        boolBuildingType = false;
        boolFurnishing = false;
        boolType = false;
        isFilterApplied = false;

    }

    public HashSet<String> getType() {
        return type;
    }

    public HashSet<String> getBuildingType() {
        return buildingType;
    }

    public HashSet<String> getFurnishing() {
        return furnishing;
    }

    public Boolean getBoolType() {
        return boolType;
    }


    public Boolean getBoolBuildingType() {
        return boolBuildingType;
    }

    public Boolean getBoolFurnishing() {
        return boolFurnishing;
    }

    public Boolean getFilterApplied() {
        return isFilterApplied;
    }


    public void setBoolType(Boolean boolType) {
        this.boolType = boolType;
    }

    public void setBoolBuildingType(Boolean boolBuildingType) {
        this.boolBuildingType = boolBuildingType;
    }

    public void setBoolFurnishing(Boolean boolFurnishing) {
        this.boolFurnishing = boolFurnishing;
    }

    public void setFilterApplied(Boolean filterApplied) {
        isFilterApplied = filterApplied;
    }

    public ArrayList<Property> getPropertyListToShow() {
        return propertyListToShow;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    public  ArrayList<Property> getPropertyList() {
        return propertyList;
    }
}
