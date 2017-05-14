package com.sh.model;


/**
 * Created by shanaulhaque on 12/05/17.
 */

public class Address {

    private String state;
    private String city;
    private String street;
    private Integer pinCode;


    public Address(){

    }


    public Address(String state, String city, String street, Integer pinCode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }


}
