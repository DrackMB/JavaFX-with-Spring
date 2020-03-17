/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compati.test22;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author dell
 */
public interface UserService {

    @GET("GestionDeParking/Reservation/ALL/")
    public Call<List<Reservation>> getUser();
    @GET("GestionDeParking/Reservation/ClientNumCIN/{cin}")
    public Call<Reservation> getReservation(@Path("cin") String cin);
    @GET("Admin/user/{user}")
    public Call<Administrateur> findByLogin(@Path("user") String user);

   
    
}
