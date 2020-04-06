package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agent {

    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("numCIN")
    @Expose
    private String numCIN;
    @SerializedName("dateDeRecreutment")
    @Expose
    private String dateDeRecreutment;

    @SerializedName("parking")
    @Expose
    private Parking parking;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumCIN() {
        return numCIN;
    }

    public void setNumCIN(String numCIN) {
        this.numCIN = numCIN;
    }

    public String getDateDeRecreutment() {
        return dateDeRecreutment;
    }

    public void setDateDeRecreutment(String dateDeRecreutment) {
        this.dateDeRecreutment = dateDeRecreutment;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
    

    public Agent(String nom, String prenom, String numCIN, String dateDeRecreutment, Parking parking) {
        this.nom = nom;
        this.prenom = prenom;
        this.numCIN = numCIN;
        this.dateDeRecreutment = dateDeRecreutment;
        this.parking = parking;
    }

   

}
