/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjouterParkingController implements Initializable {
    @FXML
    JFXButton ajouter;
    @FXML
    JFXTextField libelle;
    @FXML
    JFXTextField adress;
    @FXML
    JFXTextField errore;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
