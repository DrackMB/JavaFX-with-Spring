package com.GestionDeParking.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Temporal(TemporalType.DATE)
    private String dateEntre;
    //@Temporal(TemporalType.DATE)
    private String dateSortie;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Parking parking;
    private boolean valide;

    public Parking getParking() {
         return this.parking;
    }

    public void setParking(Parking parking) {
         this.parking = parking;
    }

    public String getDateEntre() {
         return this.dateEntre;
    }

    public void setDateEntre(String dateEntre) {
         this.dateEntre = dateEntre;
    }

    public String getDateSortie() {
         return this.dateSortie;
    }

    public void setDateSortie(String dateSortie) {
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

    @Override
    public String toString() {
         return "com.GestionDeParking.bean.Reservation[ id=" + this.id + " ]";
    }
}


/* Location:              C:\Users\dell\Documents\NetBeansProjects\mavenproject7\GestionDeParkingSpring\target\classes\!\com\GestionDeParking\bean\Reservation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
