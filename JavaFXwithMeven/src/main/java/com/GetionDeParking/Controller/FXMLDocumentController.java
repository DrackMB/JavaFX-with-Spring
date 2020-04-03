/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import com.compati.test22.UserService;
import com.compati.test22.UserServiceClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *
 * @author dell
 */
public class FXMLDocumentController implements Initializable {
    static final String BASE_URL = "http://localhost:8090/";
    Gson gson = new GsonBuilder()
                .setLenient()
                .create();
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    
    @FXML
    private Label label;
    @FXML
    private Button client;
    
    @FXML
    private Button admine;
    

    
    
    @FXML
    private void AccetClient(ActionEvent event) throws IOException {
       client.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ClientPage.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Client Scene");
        stage.setScene(scene);
        stage.show();
    }
        
    
    @FXML
     private void AccetAdmin(ActionEvent event) throws IOException {
        admine.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeAdminPage.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("AdminStrateur Scene");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Font f = null;
        try {
            f = Font.loadFont(new FileInputStream(new File("C:\\Users\\dell\\Documents\\NetBeansProjects\\JavaFXwithMeven\\src\\main\\resources\\Font\\PG_IsadoraCyrPro-Regular.ttf")),48);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         label.setFont(f);
    }    
    
}
