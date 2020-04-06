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
import com.jfoenix.controls.JFXButton;
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
 *
 * @author dell
 */
public class SuprimerAgentController implements Initializable {

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
    private TableView<Agent> tableView = new TableView<>();
    @FXML
    private TableColumn<Agent, String> nom;
    @FXML
    private TableColumn<Agent, String> prenom;
    @FXML
    private TableColumn<Agent, String> numCIN;
    @FXML
    private TableColumn<Agent, String> dateDeRecreutment;
    @FXML
    private TableColumn agent;

    @FXML
    private JFXButton deleteAgent;

    @FXML
    private JFXButton terminer;
    @FXML
    private Label lablle;
    
    @FXML
    public void terminer(ActionEvent event) {
        terminer.getScene().getWindow().hide();

    }
    @FXML
    public void deleteAgent(ActionEvent event){
         Agent ra = tableView.getSelectionModel().getSelectedItem();
        lablle.setText( "Vous avez supprimer L'agent De nom :  "+ ra.getNom());
        Call<Integer> deleteAgent = requet.deleteAgent(ra.getNumCIN());
        deleteAgent.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                if (rspns.isSuccessful()) {
                    if (rspns.body() > 0) {
                        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
                    }
                } else {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Call<List<Agent>> findALL = requet.findAllAgent();
        findALL.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> rspns) {
                List<Agent> p = rspns.body();
                ObservableList<Agent> obList = FXCollections.observableList(p);
                nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                numCIN.setCellValueFactory(new PropertyValueFactory<>("numCIN"));
                dateDeRecreutment.setCellValueFactory(new PropertyValueFactory<>("dateDeRecreutment"));
                tableView.setItems(obList);
                tableView.setEditable(true);
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });
    }

}
