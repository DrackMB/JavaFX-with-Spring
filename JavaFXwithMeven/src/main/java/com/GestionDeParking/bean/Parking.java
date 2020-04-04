package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parking {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("liblle")
    @Expose
    private String liblle;
    @SerializedName("adress")
    @Expose
    private String adress;

    public Parking(String liblle, String adress) {
        this.liblle = liblle;
        this.adress = adress;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiblle() {
        return liblle;
    }

    public void setLiblle(String liblle) {
        this.liblle = liblle;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
