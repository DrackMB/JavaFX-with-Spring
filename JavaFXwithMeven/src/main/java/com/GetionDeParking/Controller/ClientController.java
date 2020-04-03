/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 *
 * @author dell
 */
public class ClientController implements Initializable  {
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
    private Button reserver;
    
    
    @FXML
    private void AccetClient(ActionEvent event){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
