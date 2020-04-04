package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("numCIN")
    @Expose
    private String numCIN;
    @SerializedName("numMatricule")
    @Expose
    private String numMatricule;
    @SerializedName("numTele")
    @Expose
    private String numTele;

    public Client(String numCIN, String numMatricule, String numTele) {
        this.numCIN = numCIN;
        this.numMatricule = numMatricule;
        this.numTele = numTele;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCIN() {
        return numCIN;
    }

    public void setNumCIN(String numCIN) {
        this.numCIN = numCIN;
    }

    public String getNumMatricule() {
        return numMatricule;
    }

    public void setNumMatricule(String numMatricule) {
        this.numMatricule = numMatricule;
    }

    public String getNumTele() {
        return numTele;
    }

    public void setNumTele(String numTele) {
        this.numTele = numTele;
    }

}
