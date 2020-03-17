package com.GestionDeParking.bean;

import java.io.Serializable;


public class Places
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Double nbrPlaces;
    private Parking parking;

    public Double getNbrPlaces() {
        return this.nbrPlaces;
    }

    public void setNbrPlaces(Double nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public Parking getParking() {
        return this.parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public int hashCode() {
         int hash = 0;
         hash += (this.id != null) ? this.id.hashCode() : 0;
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Places)) {
            return false;
        }
         Places other = (Places) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
             return false;
        }
         return true;
    }

    @Override
    public String toString() {
         return "com.GestionDeParking.bean.Places[ id=" + this.id + " ]";
    }
}



