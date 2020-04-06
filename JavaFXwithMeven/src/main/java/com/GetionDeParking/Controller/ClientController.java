/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *
 * @author dell
 */
public class ClientController implements Initializable {

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
    private Label label;
    @FXML
    private AnchorPane parentPane;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXButton reserver;

    @FXML
    private JFXTextField numCIN;

    @FXML
    private JFXTextField matriculeN;

    @FXML
    private JFXTextField numTele;
    @FXML
    private JFXDatePicker dateDeSorter;
    @FXML
    private ChoiceBox parking = new ChoiceBox();
    int x = 0;

    @FXML
    private void saveReservation(ActionEvent event) {

        //
        Parking vparking = null;

        Client clients = new Client(numCIN.getText(), matriculeN.getText(), numTele.getText());
         x=1;
        Call<Parking> parkingRes = requet.findByLibelle((String) parking.getSelectionModel().getSelectedItem());
        parkingRes.enqueue(new Callback<com.GestionDeParking.bean.Parking>() {
            @Override
            public void onResponse(Call<Parking> call, Response<Parking> parkingRes) {
                if (parkingRes.isSuccessful()) {
                    Reservation reservation = new Reservation(new Date().toString(), dateDeSorter.getValue().toString(), clients, parkingRes.body(), true);
                    Call<Integer> logins = requet.save(reservation);
                    logins.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                           x = rspns.body();
                            System.out.println(rspns.body());

                        }

                        @Override
                        public void onFailure(Call<Integer> call, Throwable thrwbl) {
                            thrwbl.printStackTrace();
                        }

                    });

                }
           }

            @Override
            public void onFailure(Call<Parking> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
        if (x == 1) {
            reserver.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/AcceptationDinscriptionEtReservation.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            stage.setTitle("Home Scene");
            stage.setScene(scene);
            stage.show();
        }

    }

    private void choiseBoxe() {

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
        userName.setStyle("-fx-text-inner-color:#a0a2ab");
        numCIN.setStyle("-fx-text-inner-color:#a0a2ab");
        matriculeN.setStyle("-fx-text-inner-color:#a0a2ab");
        numTele.setStyle("-fx-text-inner-color:#a0a2ab");
        dateDeSorter.setStyle("-fx-text-inner-color:#a0a2ab");
        parking.setStyle("-fx-text-inner-color:#a0a2ab");

    }

}
