package com.GestionDeParking.WebService;

import com.GestionDeParking.Service.facad.AgentService;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GestionDeParking/Agent")
public class AgentRes {

    @Autowired
    private AgentService agentService;

//    @PostMapping("/")
//    public int ajouterReservation(@RequestBody Reservation reservation) {
//        return agentService.ajouterReservation(reservation);
//    }
 
    @PutMapping("/validerReservation/valide/{valide}")
    public int validerReservation(@PathVariable boolean valide, @RequestBody Reservation reservation) {
        return agentService.validerReservation(valide, reservation);
    }
    @GetMapping("/afficherReservation/")
    public Reservation afficherReservation(@PathVariable Client client) {
        return agentService.afficherReservation(client);
    }
    @PutMapping("/Place/nbPlace/{nbPlace}")
    public int ajouterPlace(@PathVariable int nbPlace,@RequestBody Parking parking) {
        return this.agentService.ajouterPlace(nbPlace, parking);
    }
    @Transactional
    @DeleteMapping("/NumCIN/{NumCIN}")
    public int deleteByNumCIN( @PathVariable String NumCIN) {
        return this.agentService.deleteByNumCIN(NumCIN);
    }
    @PostMapping("/")
    public int save(@RequestBody Agent agent) {
        return this.agentService.save(agent, agent.getParking());
    }
    @GetMapping("/numCIN/{numCIN}")
    public Agent findByNumCIN( @PathVariable String numCIN) {
        return agentService.findByNumCIN(numCIN);
    }
    @GetMapping("/parkingLibelle/{liblle}")
    public List<Agent> findByParkingLiblle( @PathVariable String liblle) {
        return agentService.findByParkingLiblle(liblle);
    }
    @GetMapping("/")
    public List<Agent> findAll() {
        return agentService.findAll();
    }
    
    
}
