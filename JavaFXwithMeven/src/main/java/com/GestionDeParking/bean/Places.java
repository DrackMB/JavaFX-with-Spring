package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Places {
    
    @SerializedName("nbrPlaces")
    @Expose
    private String nbrPlaces;
    @SerializedName("parking")
    @Expose
    private Parking parking;

    public String getNbrPlaces() {
        return nbrPlaces;
    }

    public void setNbrPlaces(String nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
    

}
