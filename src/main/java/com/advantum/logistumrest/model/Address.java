package com.advantum.logistumrest.model;


public class Address {


    private String title;
    private double lat;
    private double lng;


    public Address() {
    }

    public Address(String title, double lat, double lng) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


}
