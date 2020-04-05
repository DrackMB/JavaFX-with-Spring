package com.GestionDeParking.WebService;

import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GestionDeParking/Reservation")
public class ReservationRes {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/ClientNumCIN/{numCIN}")
    public Reservation findByClientNumCIN(@PathVariable String numCIN) {
        return reservationService.findByClientNumCIN(numCIN);
    }

    @Transactional
    @DeleteMapping("/ClientNumCIN/{numCIN}")
    public int deleteByClientNumCIN(@PathVariable String numCIN) {
        return reservationService.deleteByClientNumCIN(numCIN);
    }

    @PostMapping("/")
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
//    @PutMapping("/Reservation/validat/{valide}")
//    public int validateReservation( @PathVariable boolean valide,@RequestBody Reservation reservation) {
//        return reservationService.validateReservation(valide, reservation);
//    }

    @Transactional
    @PutMapping("/Reservation/validat/{valide}")
    public int validateReservation(@PathVariable boolean valide, @RequestBody Client client) {
        return reservationService.validateReservation(valide, client);
    }

    @GetMapping("/ALL/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }
    @GetMapping("/parkingLibelle/{liblle}")
    public List<Reservation> findByParkingLiblle( @PathVariable String liblle) {
        return reservationService.findByParkingLiblle(liblle);
    }
    
}
