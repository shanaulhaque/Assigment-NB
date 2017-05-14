package com.sh.nobroker;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.sh.model.AppModel;

import java.util.ArrayList;

/**
 * Created by shanaulhaque on 14/05/17.
 */

public class FilterPropertyUIController  implements View.OnClickListener{

    public static final String TAG = FilterPropertyUIController.class.getSimpleName();

    private FilterProperty filterProperty;

    private AppModel appModel;


    private Button refresh,close;
    private RelativeLayout applyFilter;
    private ToggleButton rk1, bhk1, bhk2, bhk3, bhk4, bhk4plus, apartment, house, floor, semiFurnished, fullFurnished, notFurnished;
    private ArrayList<ToggleButton> filterTypeToggleButton = new ArrayList();
    private ArrayList<ToggleButton> filterBuildingTypeToggleButton = new ArrayList();
    private ArrayList<ToggleButton> filterFurnishingToggleButton = new ArrayList();


    public FilterPropertyUIController(FilterProperty filterProperty){
        this.filterProperty = filterProperty;
        appModel = AppModel.getInstance(filterProperty);
    }

    void initResource(){

        refresh = (Button) filterProperty.findViewById(R.id.btn_refresh);
        close = (Button) filterProperty.findViewById(R.id.btn_close);
        applyFilter = (RelativeLayout) filterProperty.findViewById(R.id.rl_apply);

        rk1 = (ToggleButton) filterProperty.findViewById(R.id.tb_rk1);
        bhk1 = (ToggleButton) filterProperty.findViewById(R.id.tb_bhk1);
        bhk2 = (ToggleButton) filterProperty.findViewById(R.id.tb_bhk2);
        bhk3 = (ToggleButton) filterProperty.findViewById(R.id.tb_bhk3);
        bhk4 = (ToggleButton) filterProperty.findViewById(R.id.tb_bhk4);
        bhk4plus = (ToggleButton) filterProperty.findViewById(R.id.tb_bhk4_plus);
        apartment = (ToggleButton) filterProperty.findViewById(R.id.apartment);
        house = (ToggleButton) filterProperty.findViewById(R.id.independent_house_villa);
        floor = (ToggleButton) filterProperty.findViewById(R.id.independent_floor_builder);
        semiFurnished = (ToggleButton) filterProperty.findViewById(R.id.semi);
        fullFurnished = (ToggleButton) filterProperty.findViewById(R.id.full);
        notFurnished = (ToggleButton) filterProperty.findViewById(R.id.none_furnished);

        filterTypeToggleButton.add(rk1);
        filterTypeToggleButton.add(bhk1);
        filterTypeToggleButton.add(bhk2);
        filterTypeToggleButton.add(bhk3);
        filterTypeToggleButton.add(bhk4);
        filterTypeToggleButton.add(bhk4plus);
        filterBuildingTypeToggleButton.add(apartment);
        filterBuildingTypeToggleButton.add(house);
        filterBuildingTypeToggleButton.add(floor);
        filterFurnishingToggleButton.add(semiFurnished);
        filterFurnishingToggleButton.add(fullFurnished);
        filterFurnishingToggleButton.add(notFurnished);




        refresh.setOnClickListener(this);
        close.setOnClickListener(this);
        applyFilter.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_refresh:
                clearToggle();
                break;
            case R.id.rl_apply:
                addFilter();
                filterProperty.setResult(Activity.RESULT_OK, null);
                appModel.getPropertyListToShow().clear();
                appModel.setPageNumber(0);
            case R.id.btn_close:
                filterProperty.finish();
                filterProperty.overridePendingTransition( R.anim.do_nothing, R.anim.slide_down);
                break;

        }
    }

    private void addFilter(){

        appModel.setBoolType(false);
        appModel.setBoolBuildingType(false);
        appModel.setBoolFurnishing(false);
        appModel.getType().clear();
        appModel.getBuildingType().clear();
        appModel.getFurnishing().clear();

        for (ToggleButton button : filterTypeToggleButton) {
            if(button.isChecked()){
                appModel.getType().add(filterProperty.filterMap.get(button.getId()));
                appModel.setBoolType(true);
            }
        }
        for (ToggleButton button : filterBuildingTypeToggleButton) {
            if(button.isChecked()){
                appModel.getBuildingType().add(filterProperty.filterMap.get(button.getId()));
                appModel.setBoolBuildingType(true);
            }
        }
        for (ToggleButton button : filterFurnishingToggleButton) {
            if(button.isChecked()){
                appModel.getFurnishing().add(filterProperty.filterMap.get(button.getId()));
                appModel.setBoolFurnishing(true);
            }
        }
        appModel.setFilterApplied(appModel.getBoolBuildingType() | appModel.getBoolFurnishing() | appModel.getBoolType());

    }


    private void clearToggle() {

        rk1.setChecked(false);
        bhk1.setChecked(false);
        bhk2.setChecked(false);
        bhk3.setChecked(false);
        bhk4.setChecked(false);
        bhk4plus.setChecked(false);
        apartment.setChecked(false);
        house.setChecked(false);
        floor.setChecked(false);
        semiFurnished.setChecked(false);
        fullFurnished.setChecked(false);
        notFurnished.setChecked(false);
    }

}
