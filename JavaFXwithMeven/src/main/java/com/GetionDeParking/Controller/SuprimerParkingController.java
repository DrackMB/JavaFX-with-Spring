/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class SuprimerParkingController implements Initializable {

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
    private JFXButton deleteParking;

    @FXML
    private JFXButton terminer;

    @FXML
    private JFXButton afficherALL;

    @FXML
    private Label NameParking;

    @FXML
    private TableView<Parking> tableView = new TableView<>();
    @FXML
    private TableColumn<Parking, String> liblle;
    @FXML
    private TableColumn<Parking, String> adress;
    @FXML
    private TableColumn parking;

    @FXML
    public void deleteParking(ActionEvent event) {
        Parking ra = tableView.getSelectionModel().getSelectedItem();
        
        Call<Integer> deleteParking = requet.deleteParking(ra.getLiblle());
        deleteParking.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                if (rspns.isSuccessful()) {
                    if (rspns.body() > 0) {
                        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
                       // NameParking.setText( "Vous avez supprimer Le parking "+ ra.getLiblle());
                    }
                } else {
                    NameParking.setText( "eroore");
                    System.out.println("eroore");
                    System.out.println(rspns.body());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });

    }

    @FXML
    public void terminer(ActionEvent event) {
        terminer.getScene().getWindow().hide();

    }

    @FXML
    public void select(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Call<List<Parking>> findALL = requet.findAllParking();
        findALL.enqueue(new Callback<List<Parking>>() {
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> rspns) {
                List<Parking> p = rspns.body();
                ObservableList<Parking> obList = FXCollections.observableList(p);
                liblle.setCellValueFactory(new PropertyValueFactory<>("liblle"));
                adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
                tableView.setItems(obList);
                tableView.setEditable(true);
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });
        NameParking.setStyle("-fx-text-inner-color:#a0a2ab");
        
    }
}
