package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservation {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("dateEntre")
    @Expose
    private String dateEntre;
    @SerializedName("dateSortie")
    @Expose
    private String dateSortie;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("parking")
    @Expose
    private Parking parking;
    @SerializedName("valide")
    @Expose
    private Boolean valide;

    public Reservation(String dateEntre, String dateSortie, Client client, Parking parking, Boolean valide) {
        this.dateEntre = dateEntre;
        this.dateSortie = dateSortie;
        this.client = client;
        this.parking = parking;
        this.valide = valide;
    }
    
    

    public String getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(String dateEntre) {
        this.dateEntre = dateEntre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    @Override
    public String toString() {
        return "Reservation{" + "dateEntre=" + dateEntre + ", dateSortie=" + dateSortie + ", client=" + client + ", parking=" + parking + ", valide=" + valide + '}';
    }

}
