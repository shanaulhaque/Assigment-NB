package com.sh.model;

import java.util.ArrayList;

/**
 * Created by shanaulhaque on 12/05/17.
 */





public class Property {





    private String id;
    private String title;
    private String secondaryTitle;
    private Integer rent;
    private String furnishing;
    private Integer deposit;
    private ArrayList<String> imageAddress;
    private Boolean imageAvailable;
    private Address address;
    private Integer propertySize;
    private Integer noOfBathrooms;
    private String furnishingDesc;
    private String type;
    private String buildingType;

    public Integer getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(Integer noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public String getFurnishingDesc() {
        return furnishingDesc;
    }

    public void setFurnishingDesc(String furnishingDesc) {
        this.furnishingDesc = furnishingDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public Integer getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(Integer propertySize) {
        this.propertySize = propertySize;
    }

    public Boolean getImageAvailable() {
        return imageAvailable;
    }

    public void setImageAvailable(Boolean imageAvailable) {
        this.imageAvailable = imageAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(ArrayList<String> imageAddress) {
        this.imageAddress = imageAddress;
    }


    public String getSecondaryTitle() {
        return secondaryTitle;
    }

    public void setSecondaryTitle(String secondaryTitle) {
        this.secondaryTitle = secondaryTitle;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
