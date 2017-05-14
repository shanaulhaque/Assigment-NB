package com.sh.nobroker;

import android.app.Activity;
import android.util.Log;

import com.sh.model.Address;
import com.sh.model.AppModel;
import com.sh.model.Property;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by shanaulhaque on 13/05/17.
 */

public class ParsePropertyDetail {


    public static final String TAG = ParsePropertyDetail.class.getSimpleName();

    public void parse(String jsonStr, Activity activity){
        AppModel appModel = AppModel.getInstance(activity);
        appModel.getPropertyList().clear();
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray properties = jsonObj.getJSONArray("data");

                // looping through All property
                for (int i = 0; i < properties.length(); i++) {
                    JSONObject property_json = properties.getJSONObject(i);

                    Property property = new Property();
                    Address address = new Address();

                    property.setTitle(property_json.optString("id"));
                    property.setTitle(property_json.optString("propertyTitle"));
                    property.setDeposit(property_json.optInt("deposit"));
                    property.setSecondaryTitle(property_json.optString("secondaryTitle"));
                    property.setRent(property_json.optInt("rent"));
                    property.setPropertySize(property_json.optInt("propertySize"));
                    property.setImageAvailable(property_json.optBoolean("photoAvailable"));
                    property.setFurnishing(property_json.optString("furnishing"));
                    property.setFurnishingDesc(property_json.optString("furnishingDesc"));
                    property.setNoOfBathrooms(property_json.optInt("bathroom"));
                    property.setType(property_json.optString("type"));
                    property.setBuildingType(property_json.getString("buildingType"));

                    address.setCity(property_json.optString("city"));
                    address.setPinCode(property_json.optInt("pinCode"));
                    address.setStreet(property_json.optString("street"));

                    property.setAddress(address);


                    if(property.getImageAvailable()){
                        JSONArray photos = property_json.getJSONArray("photos");
                        ArrayList<String> photosList = new ArrayList<>();
                        for (int j = 0; j < photos.length(); j++) {
                            JSONObject photo_json = photos.getJSONObject(j);
                            JSONObject imageMap = photo_json.getJSONObject("imagesMap");
                            photosList.add(imageMap.optString("medium"));
                        }
                        property.setImageAddress(photosList);
                    }

                    appModel.getPropertyList().add(property);

                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");

        }
    }



}
