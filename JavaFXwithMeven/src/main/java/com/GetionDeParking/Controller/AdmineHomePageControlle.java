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
    private void handleButtonAction(ActionEvent event) {

        Call<Administrateur> logins = requetVerification.findByLogin(username.getText());
        logins.enqueue(new Callback<Administrateur>() {
            @Override
            public void onResponse(Call<Administrateur> call, Response<Administrateur> rspns) {
                if (rspns.isSuccessful()) {

                    Administrateur adminResult = rspns.body();
                    if (adminResult.getMdp().equals(password.getText())) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                
                                AdminControlle  adminControlle = null;
                                            
                                    login.getScene().getWindow().hide();
                                    Parent root = null;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("/fxml/AdminFX.fxml"));

                                    } catch (IOException ex) {
                                        Logger.getLogger(AdmineHomePageControlle.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    Stage stage = new Stage();
                                    Scene scene = new Scene(root);
                                    scene.getStylesheets().add("/styles/Styles.css");
                                    stage.setTitle("Admin");
                                    stage.setScene(scene);
                                    stage.show();
                                
                            }

                        });

                    }

                } else {
                    System.out.println("erooore" + rspns.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Administrateur> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        password.setStyle("-fx-text-inner-color:#a0a2ab");

        username.setStyle("-fx-text-inner-color:#a0a2ab");
    }
}
