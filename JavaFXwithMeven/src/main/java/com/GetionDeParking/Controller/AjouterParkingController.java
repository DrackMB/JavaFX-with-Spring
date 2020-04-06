/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Parking;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjouterParkingController implements Initializable {

    static final String BASE_URL = "http://localhost:8090/";
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    RequetAdmine requet = retrofit.create(RequetAdmine.class);
    @FXML
    JFXButton ajouter;
    @FXML
    JFXTextField libelle;
    @FXML
    JFXTextField adress;
    @FXML
    Label errore;

    @FXML
    public void saveParking(ActionEvent event) {
        Parking p = new Parking(libelle.getText(), adress.getText());
        Call<Integer> save = requet.saveParking(p);
        save.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                if (rspns.isSuccessful()) {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (rspns.body() > 0) {
                                errore.setText("Votre Parking  " + libelle.getText() + "  a été Ajouter dans nos Collection Merci de Votre Confiance ");
                            } else {
                                errore.setText("error ");
                            }
                        }  
                });

            }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        libelle.setStyle("-fx-text-inner-color:#a0a2ab");
        adress.setStyle("-fx-text-inner-color:#a0a2ab");
    }

}
