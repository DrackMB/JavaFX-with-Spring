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
import org.springframework.transaction.annotation.Transactional;

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

    public int Login(String user,String mdp) {
            Administrateur administrateur = administrateurRepository.findByLogin(user); 
            if(administrateur!=null){
                if(administrateur.getMdp().equals(mdp)){
                    if(administrateur.getType().equals("AD")){
                        return 1;
                    }else if(administrateur.getType().equals("SAD")){
                        return 2;
                    }
                    
                }else return -1;
            }return -2;
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

    @Override
    public int save(Administrateur administrateur) {
        administrateurRepository.save(administrateur);
        return 1;
    }
    @Transactional
    @Override
    public int deleteByLogin(String login) {
     return administrateurRepository.deleteByLogin(login);
    }

    @Override
    public List<Administrateur> findAll() {
        return administrateurRepository.findAll();
    }
}


