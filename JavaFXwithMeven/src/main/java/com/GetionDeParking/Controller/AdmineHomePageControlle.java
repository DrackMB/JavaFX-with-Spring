package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Administrateur;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdmineHomePageControlle implements Initializable {

    static Integer x = 0;
    static final String BASE_URL = "http://localhost:8090/";
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    RequetAdmine requetVerification = retrofit.create(RequetAdmine.class);
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXCheckBox remmnber;

    @FXML
    private JFXButton forgetpassword;

    @FXML
    private Label errore;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!username.getText().isEmpty() || password.getText().isEmpty()) {
            Call<Integer> logins = requetVerification.findByLogin(username.getText(),password.getText());
            logins.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> rspns) {
                    //if (rspns.isSuccessful()) {
                        if (rspns.body() != null && rspns.body()>0) {
                            int adminResult = rspns.body();
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        login.getScene().getWindow().hide();
                                        Parent root = null;
                                        if (adminResult == 1) {
                                            try {
                                                root = FXMLLoader.load(getClass().getResource("/fxml/AdminFX.fxml"));

                                            } catch (IOException ex) {
                                                Logger.getLogger(AdmineHomePageControlle.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else if (adminResult==2) {
                                            try {
                                                root = FXMLLoader.load(getClass().getResource("/fxml/SuperAdminFX.fxml"));

                                            } catch (IOException ex) {
                                                Logger.getLogger(AdmineHomePageControlle.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }

                                        Stage stage = new Stage();
                                        Scene scene = new Scene(root);
                                        scene.getStylesheets().add("/styles/Styles.css");
                                        stage.setTitle("Admin");
                                        stage.setScene(scene);
                                        stage.show();

                                    }

                                });

                           
                                
                            
                        } else {
                            errore.setText("Compte n'existe pas ou bient User ou mdp incorrect");
                        }

                  //  }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable thrwbl) {
                    thrwbl.printStackTrace();
                }
            });

        } else {
            errore.setText(" un  de deux champ est vide ");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        password.setStyle("-fx-text-inner-color:#a0a2ab");

        username.setStyle("-fx-text-inner-color:#a0a2ab");
    }
}
