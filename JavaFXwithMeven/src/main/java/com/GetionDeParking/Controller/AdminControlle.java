package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Administrateur;
import com.compati.test22.RequetAdmine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javax.swing.JLabel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdminControlle implements Initializable {

    int x = 0;
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
    private JFXButton accesParking;
    @FXML
    private JFXButton ajouterParking;
    @FXML
    private JFXButton suprimerParking;
    @FXML
    private JFXButton ajouterAgent;
    @FXML
    private JFXButton suprimerAgent;
    @FXML
    private JFXButton Deconneter;
    @FXML
    private JFXTextField NameParking;
    @FXML
    private 
    JLabel label ;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {

        Call<Administrateur> logins = requetVerification.findByLogin("");
        logins.enqueue(new Callback<Administrateur>() {
            @Override
            public void onResponse(Call<Administrateur> call, Response<Administrateur> rspns) {
                if (rspns.isSuccessful()) {

                    Administrateur adminResult = rspns.body();
                    

                } else {
                    System.out.println("erooore" + rspns.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Administrateur> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
        if (x == 1) {
            ajouterParking.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/AdminFX.fxml"));

            } catch (IOException ex) {
                Logger.getLogger(AdminControlle.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("Admin");
            stage.setScene(scene);
            stage.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NameParking.setStyle("-fx-text-inner-color:#a0a2ab");

        
    }
}
