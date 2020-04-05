package com.GetionDeParking.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Reservation;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
public class AccetParkingController implements Initializable {

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
    private TableView<Reservation> tableView = new TableView<>();
//    @FXML
//    private TableColumn<Agent, String> nom;
//    @FXML
//    private TableColumn<Agent, String> prenom;
//    @FXML
//    private TableColumn<Agent, String> numCIN;
//    @FXML
//    private TableColumn<Agent, Agent> agent;
    //--------------------------------------
    @FXML
    private TableColumn<Reservation, String> dateEntre ;
    @FXML
    private TableColumn<Reservation, String> dateSortie; 
    @FXML
    private TableColumn<Reservation, Long> client ;
    @FXML
    private TableColumn<Reservation, Boolean> valide ;
    @FXML
    private TableColumn reservation ;
    @FXML
    JFXButton ok;
    @FXML
    private JFXTextField t;

    public void SetText(String text) {
        t.setText(text);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(t.getText() + "  text in call");
        Call<List<Reservation>> reservations = requet.findListeReservationParking(t.getText());
        reservations.enqueue(new Callback<List<Reservation>>() {
            @Override
            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> rspns) {
                if (rspns.isSuccessful()) {
     List<Reservation> r = rspns.body();
                    

                                    ObservableList<Reservation> obList = FXCollections.observableArrayList(r);
                                    dateEntre.setCellValueFactory(new PropertyValueFactory<>("dateEntre"));
                                    dateSortie.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
                                    client.setCellValueFactory(new PropertyValueFactory<>("client"));
                                    valide.setCellValueFactory(new PropertyValueFactory<>("valide"));
                                   //reservation.setCellValueFactory(new PropertyValueFactory<>("Reservation"));
                                    //reservation.getColumns().addAll(dateEntre, dateSortie, client, valide);
                                    tableView.setItems(obList);
                                    tableView.getColumns().addAll(dateEntre, dateSortie, client, valide);
                                    tableView.setEditable(true);
                                    System.out.println(obList);
                }
            }

            @Override
            public void onFailure(Call<List<Reservation>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println(label.getText());

    }

}
