package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Administrateur;
import com.GestionDeParking.bean.Parking;
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
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
    RequetAdmine requet = retrofit.create(RequetAdmine.class);
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
    private Label label;

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        Call<Parking> logins = requet.findByLibelle(NameParking.getText());
        logins.enqueue(new Callback<Parking>() {
            @Override
            public void onResponse(Call<Parking> call, Response<Parking> rspns) {
                if (rspns.isSuccessful()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            accesParking.getScene().getWindow().hide();
                            FXMLLoader loade = new FXMLLoader(getClass().getResource("/fxml/AccetParking.fxml"));
                            Parent root = null;
                            try {
                                root = loade.load();

                            } catch (IOException ex) {
                                Logger.getLogger(AdmineHomePageControlle.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            AccetParkingController a = loade.getController();
                            a.SetText(NameParking.getText());
                            Stage stage = new Stage();
                            Scene scene = new Scene(root);
                            scene.getStylesheets().add("/styles/Styles.css");
                            stage.setTitle("Admin");
                            stage.setScene(scene);
                            stage.show();
                        }

                    });

                }

            }

            @Override
            public void onFailure(Call<Parking> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }

            // }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NameParking.setStyle("-fx-text-inner-color:#a0a2ab");

    }
}
