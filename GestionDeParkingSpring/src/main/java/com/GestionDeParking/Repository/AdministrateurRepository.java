package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    Administrateur findByLogin(String login);

    int deleteByLogin(String login);

}
