package com.liftoff.spots.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity //store class in DB

public class Spot {


    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Spot spot;

    @NotNull
    private String spotName;


    private String spotInfo;

    @NotNull
    private double Longitude;

    @NotNull
    private double Latitude;

    private boolean Enable = true;



    public Spot(int id, String spotName, String spotInfo, double Longitude, double Latitude, boolean Enable) {
        this.id = id;
        this.spotName = spotName;
        this.spotInfo = spotInfo;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.Enable = Enable;

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
