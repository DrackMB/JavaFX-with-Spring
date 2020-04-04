package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.ClientRepository;
import com.GestionDeParking.Service.facad.ClientService;
import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl  implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReservationService reservationService;

    @Override
    public int ajouterReservation(Reservation reservation) {
        Reservation reservationResult = this.reservationService.findByClientNumCIN(reservation.getClient().getNumCIN());
        if (reservationResult == null) {
            return -1;
        }
        return this.reservationService.save(reservation);
    }

    @Override
    public int save(Client client) {
        if(client!=null){
            if (findByNumCIN(client.getNumCIN()) == null) {
            this.clientRepository.save(client);
            return 1;
        }
            return -1;
        }
        
         return -2;
    }

    @Override
    public Client findByNumCIN(String numCIN) {
        return this.clientRepository.findByNumCIN(numCIN);
    }
}


