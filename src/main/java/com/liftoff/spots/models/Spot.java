package com.liftoff.spots.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity //store class in DB

public class Spot implements Serializable {


    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;

    @NotNull
    private String spotName;


    private String spotInfo;

    @NotNull
    private double Longitude;

    @NotNull
    private double Latitude;

    private boolean Enable = true;



    public Spot(String spotName, String spotInfo, double Longitude, double Latitude) {
        this.id = id;
        this.spotName = spotName;
        this.spotInfo = spotInfo;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.Enable = Enable;

    }
    public Spot(){

    }

    public User getUser() {
        return user;
    }

    public int getUserID() {
       int ID = getUser().getId();
       return ID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotInfo() {
        return spotInfo;
    }

    public void setSpotInfo(String spotInfo) {
        this.spotInfo = spotInfo;
    }


}
