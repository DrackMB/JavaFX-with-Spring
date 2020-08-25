/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author dell
 */
public class FXMLDocumentController implements Initializable {
 
    
    @FXML
    private Label label;
    @FXML
    private Button client;
    
    @FXML
    private Button admine;
    @FXML
    private Button admine1;
    

    
    
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
    private void AccetSuperAdmin(ActionEvent event) throws IOException {
       admine1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeAdminPage.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Super Admine Scene");
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
