/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compati.test22;

import com.GestionDeParking.bean.Reservation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javafx.fxml.FXML;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *
 * @author dell
 */
public class UserServiceClient {

    static final String BASE_URL = "http://localhost:8090/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UserService gerritAPI = retrofit.create(UserService.class);

        
//------------------------------------------------------------------
//        Call<List<Reservation>> call2 = gerritAPI.getReservation("g123");
//        
//        call2.enqueue(new Callback<List<Reservation>>() {
//            @Override
//            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> rspns) {
//                if (rspns.isSuccessful()) {
//                    List<Reservation> changesList = rspns.body();
//                    for (Reservation userApiResponse : changesList) {
//                        System.out.println(changesList);
//                    }
//
//                } else {
//                    System.out.println(rspns.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Reservation>> call, Throwable thrwbl) {
//                thrwbl.printStackTrace();
//            }
//        });

    }

}
