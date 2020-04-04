package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByClientNumCIN(String paramString);

    int deleteByClientNumCIN(String paramString);

    @Modifying
    @Query("UPDATE Reservation r set r.valide=:validat where r.client=:client")
    void validateReservation(@Param("validat") boolean validat, @Param("client") Client client);

    List<Reservation> findByParkingLiblle(String liblle);
}
