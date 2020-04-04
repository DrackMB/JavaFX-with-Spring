package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import java.util.List;

public interface AdministrateurService {

    Administrateur Login(String login);

    int suprimerParking(String libelle);

    int saveParking(Parking parking);

    int AjouterAgent(Agent agent, Parking parking);

    int suprimerAgent(String numCIN);
    
    List<Reservation> afficherListdeReservation(String liblle);
    
    


    
}
