package com.GestionDeParking.bean;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

    private Long id;
    private Date dateEntre;
    private Date dateSortie;
    private Client client;
    private Parking parking;
    private boolean valide;

    public Reservation(Long id, Date dateEntre, Date dateSortie, Client client, Parking parking, boolean valide) {
        this.id = id;
        this.dateEntre = dateEntre;
        this.dateSortie = dateSortie;
        this.client = client;
        this.parking = parking;
        this.valide = valide;
    }

    public Parking getParking() {
        return this.parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Date getDateEntre() {
        return this.dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public Date getDateSortie() {
        return this.dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isValide() {
        return this.valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Reservation{" + "id=" + id + ", dateEntre=" + dateEntre + ", dateSortie=" + dateSortie + ", client=" + client.getNumCIN() + ", parking=" + parking.getLiblle() + ", valide=" + valide + '}';
//    }

  
}


/* Location:              C:\Users\dell\Documents\NetBeansProjects\mavenproject7\GestionDeParkingSpring\target\classes\!\com\GestionDeParking\bean\Reservation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
