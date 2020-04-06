/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import okhttp3.MediaType;
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
public class AjouterAgentController implements Initializable {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
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
    private JFXTextField nom;

    @FXML
    private Label errore;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField numCIN;
    @FXML
    private JFXDatePicker dateDeRecreutment;
    @FXML
    private ChoiceBox parking = new ChoiceBox();

    @FXML
    public void saveAgent(ActionEvent event) {
        Call<Parking> findP = requet.findByLibelle((String) parking.getSelectionModel().getSelectedItem());
        findP.enqueue(new Callback<Parking>() {
            @Override
            public void onResponse(Call<Parking> call, Response<Parking> rspns) {
                if (rspns.isSuccessful()) {
                    if (rspns.body() != null) {
                        Parking par = rspns.body();
                        System.out.println("parking li ja mn initialized " +par.getAdress()+" "+par.getLiblle());
                        if (par != null) {
                            Agent a = new Agent(nom.getText(), prenom.getText(), numCIN.getText(), dateDeRecreutment.getValue().toString(),par);
                            if(a!=null){
                                          Call<Integer> saveAgent = requet.saveAgent(a);
                            saveAgent.enqueue(new Callback<Integer>() {
                                @Override
                                public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                                    if (rspns.isSuccessful()) {
                                        Platform.runLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (rspns.body() > 0) {
                                                    errore.setText("Vous avez inserer un Agent de nom " + nom.getText());
                                                    System.out.println(rspns.body());
                                                } else {
                                                    errore.setText("error dans le server ");
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
                  
                        }else {System.out.println("kayen chi blan fl parking");}

                    }

                }
            }

            @Override
            public void onFailure(Call<Parking> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Call<List<Parking>> findall = requet.findAllParking();
        findall.enqueue(new Callback<java.util.List<com.GestionDeParking.bean.Parking>>() {
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> rspns) {
                if (rspns.isSuccessful()) {
                    for (Parking parking1 : rspns.body()) {
                        parking.getItems().add(parking1.getLiblle());
                        System.out.println(parking1.getLiblle());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
        nom.setStyle("-fx-text-inner-color:#a0a2ab");
        numCIN.setStyle("-fx-text-inner-color:#a0a2ab");
        prenom.setStyle("-fx-text-inner-color:#a0a2ab");
        dateDeRecreutment.setStyle("-fx-text-inner-color:#a0a2ab");
        parking.setStyle("-fx-text-inner-color:#a0a2ab");
    }

}
