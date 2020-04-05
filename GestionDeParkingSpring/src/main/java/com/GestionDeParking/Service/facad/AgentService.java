package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import java.util.List;

public interface AgentService {

    int ajouterReservation(Reservation Reservation);

    int validerReservation(boolean Boolean, Reservation Reservation);

    Reservation afficherReservation(Client Client);

    int ajouterPlace(int Int, Parking Parking);

    int deleteByNumCIN(String paramString);

    int save(Agent paramAgent, Parking paramParking);

    Agent findByNumCIN(String paramString);
    
    List<Agent> findByParkingLiblle(String liblle);
}
