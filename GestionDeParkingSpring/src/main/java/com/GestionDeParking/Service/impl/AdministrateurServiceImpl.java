package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.AdministrateurRepository;
import com.GestionDeParking.Service.facad.AdministrateurService;
import com.GestionDeParking.Service.facad.AgentService;
import com.GestionDeParking.Service.facad.ParkingService;
import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurServiceImpl  implements AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private ParkingService packageService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private ReservationService reservationService ;

    public Administrateur Login(String user) {
        return administrateurRepository.findByLogin(user);
    }

    public int suprimerParking(String liblle) {
        return this.packageService.deleteByLiblle(liblle);
    }

    public int saveParking(Parking parking) {
        return this.packageService.save(parking);
    }

    public int AjouterAgent(Agent agent, Parking parking) {
        return this.agentService.save(agent, parking);
    }

    public int suprimerAgent(String numCIN) {
        return this.agentService.deleteByNumCIN(numCIN);
    }

    @Override
    public List<Reservation> afficherListdeReservation(String liblle) {
        return reservationService.findByParkingLiblle(liblle);
    }
}


