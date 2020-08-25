/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Agent;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
public class SuperAdminFXController implements Initializable {

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
    private TableView<Administrateur> tableView = new TableView<>();
    @FXML
    private TableColumn<Administrateur, String> login;
    @FXML
    private TableColumn<Administrateur, String> mdp;
    @FXML
    private TableColumn<Administrateur, String> type;

    @FXML
    private JFXButton deleteAdmine;

    @FXML
    private JFXButton saveAdmin;

    @FXML
    private JFXTextField Login;

    @FXML
    private JFXButton deconnecter;

    @FXML
    private JFXTextField Mdp;
    @FXML
    private ChoiceBox<String> typeT = new ChoiceBox();

    @FXML
    private Label lablle;

    @FXML
    public void save(ActionEvent event) {
        Administrateur a = new Administrateur(Login.getText(), Mdp.getText(), typeT.getSelectionModel().getSelectedItem());
        Call<Integer> save = requet.save(a);
        save.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                if (rspns.isSuccessful()) {
                    System.out.println(rspns.body());
                    tableView.getItems().add(a);
                }

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });
    }

    public void deleteAD(ActionEvent event) {
        Administrateur ra = tableView.getSelectionModel().getSelectedItem();
        lablle.setText("Vous avez supprimer L'agent De nom :  " + ra.getLogin());
        Call<Integer> deleteAgent = requet.deleteAdmin(ra.getLogin());
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

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        deconnecter.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Home Scene");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Call<List<Administrateur>> findALL = requet.findAllAdm();
        findALL.enqueue(new Callback<List<Administrateur>>() {
            @Override
            public void onResponse(Call<List<Administrateur>> call, Response<List<Administrateur>> rspns) {
                System.out.println(rspns.body());
                List<Administrateur> p = rspns.body();
                ObservableList<Administrateur> obList = FXCollections.observableArrayList(p);
                login.setCellValueFactory(new PropertyValueFactory<>("login"));
                mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
                type.setCellValueFactory(new PropertyValueFactory<>("type"));

                tableView.setItems(obList);
                tableView.setEditable(true);
            }

            @Override
            public void onFailure(Call<List<Administrateur>> call, Throwable thrwbl) {
                thrwbl.getStackTrace();
            }
        });
        
        type.setStyle("-fx-text-inner-color:#a0a2ab");
        typeT.getItems().add("AD");
        typeT.getItems().add("SAD");
    }

}
