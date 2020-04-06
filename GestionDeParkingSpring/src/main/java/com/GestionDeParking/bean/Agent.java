package com.GestionDeParking.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Agent  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String numCIN;
    private String dateDeRecreutment;
    @ManyToOne
    private Parking parking;

    public String getNom() {
         return this.nom;
    }

    public void setNom(String nom) {
         this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumCIN() {
         return this.numCIN;
    }

    public void setNumCIN(String numCIN) {
         this.numCIN = numCIN;
    }

    public String getDateDeRecreutment() {
         return this.dateDeRecreutment;
    }

    public void setDateDeRecreutment(String dateDeRecreutment) {
         this.dateDeRecreutment = dateDeRecreutment;
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
         if (!(object instanceof Agent)) {
             return false;
        }
         Agent other = (Agent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
         return true;
    }

    @Override
    public String toString() {
         return "com.GestionDeParking.bean.Agent[ id=" + this.id + " ]";
    }
}


