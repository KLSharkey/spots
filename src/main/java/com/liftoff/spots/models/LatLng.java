package com.liftoff.spots.models;

import java.io.Serializable;

public class LatLng implements Serializable{
    private double latitude;
    private double longitude;

public LatLng(){}

public LatLng(double latitude, double longitude){
    this.latitude = latitude;
    this.longitude = longitude;
}

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
