/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compati.test22;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author dell
 */
public interface RequetAdmine {

    @GET("GestionDeParking/Admin/user/{users}")
    public Call<Administrateur> findByLogin(@Path("users") String user);

    @POST("GestionDeParking/Reservation/")
    @Headers("Content-Type: application/json")
    public Call<Integer> save(@Body Reservation reservation);

    @GET("GestionDeParking/Parking/")
    public Call<List<Parking>> findAllParking();

    @GET("/GestionDeParking/Parking/liblle/{libelle}")
    public Call<Parking> findByLibelle(@Path("libelle") String libelle);

    @GET("/GestionDeParking/Reservation/parkingLibelle/{liblle}")
    public Call< List<Reservation>> findListeReservationParking(@Path("liblle") String liblle);

     @GET("/GestionDeParking/Agent/parkingLibelle/{liblle}")
     public Call< List<Agent>> findListeAgentParking(@Path("liblle") String liblle);
}
