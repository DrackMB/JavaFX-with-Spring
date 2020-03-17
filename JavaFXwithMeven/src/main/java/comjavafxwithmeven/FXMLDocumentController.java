/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comjavafxwithmeven;

import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import com.compati.test22.UserService;
import com.compati.test22.UserServiceClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation,Long> id;
   
    //matricules.setCellValueFactory(new PropertyValueFactory<JoinEncadrement, String>("matricule"));
    @FXML
    private TableColumn<Reservation,Date> dateEntre;
    @FXML
    private TableColumn<Reservation,Date> dateSortie;
    
    @FXML
    private TableColumn<Reservation,Parking> parkingLibelle;
    @FXML
    private TableColumn<Reservation,Boolean> valide;
    //--------------------------------------------------
    @FXML
    private TableColumn<Reservation,Client> clientCIN;
//    @FXML
//    private TableColumn<Long,Client> clientid;
//    @FXML
//    private TableColumn<Client,String> numCIN;
//    @FXML
//    private TableColumn<Client,String> numMatricule;
//    @FXML
//    private TableColumn<Client,String> numTele;
//    //--------------------------------------
//    @FXML
//    private TableColumn<Parking,String> liblle;
//    @FXML
//    private TableColumn<Parking,String> adress;
//    @FXML
//    private TableColumn<Parking,Long> Parid;
    
    
    //id.cellValueFactoryProperty(new PropertyValueFactory<>);
    
    
    @FXML
    private void AccetClient(ActionEvent event) {
        UserService gerritAPI = retrofit.create(UserService.class);
      Call<Reservation> call2 = gerritAPI.getReservation("g123");
        
        call2.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> rspns) {
                if (rspns.isSuccessful()) {
                    Reservation changesList = rspns.body();
                    ObservableList<Reservation> obList =FXCollections.observableArrayList(changesList);
                    id.setCellValueFactory(new PropertyValueFactory<Reservation,Long>("id"));
                    dateEntre.setCellValueFactory(new PropertyValueFactory<Reservation,Date>("dateEntre"));
                    dateSortie.setCellValueFactory(new PropertyValueFactory<Reservation,Date>("dateSortie"));
                    clientCIN.setCellValueFactory(new PropertyValueFactory<Reservation,Client>("clientCIN"));
                    parkingLibelle.setCellValueFactory(new PropertyValueFactory<Reservation,Parking>("parkingLibelle"));
                    valide.setCellValueFactory(new PropertyValueFactory<Reservation,Boolean>("valide"));
                   tableView.setItems(obList);
                   tableView.getColumns().addAll(id,dateEntre,dateSortie, clientCIN, parkingLibelle, valide);
                   tableView.setEditable(true);
                   // clientid.cellValueFactoryProperty(new PropertyValueFactory<Long,Long>("clientCIN"));
                    //clientCIN.getColumns().addAll(clientid,numCIN,numMatricule,numTele);

//                    id.setText(String.valueOf(changesList.getId()));
//                    dateEntre.setText(String.valueOf(changesList.getDateEntre()));
//                    dateSortie.setText(String.valueOf(changesList.getDateSortie()));
                    //clientCIN.setText(changesList.getClient().getNumCIN());
                    
                        System.out.println(changesList);
                        
                    }

                 else {
                    System.out.println(rspns.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
;
        
    }
    @FXML
     private void AccetAdmin(ActionEvent event) throws IOException {
         
//         
//         UserService gerritAPI = retrofit.create(UserService.class);
//       Call<List<Reservation>> call = gerritAPI.getUser();
//        
//        call.enqueue(new Callback<List<Reservation>>() {
//            @Override
//            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> rspns) {
//                if (rspns.isSuccessful()) {
//                    List<Reservation> changesList = rspns.body();
//                    ObservableList<Reservation> obList =FXCollections.observableArrayList(changesList);
//                    id.setCellValueFactory(new PropertyValueFactory<Reservation,Long>("id"));
//                    dateEntre.setCellValueFactory(new PropertyValueFactory<Reservation,Date>("dateEntre"));
//                    dateSortie.setCellValueFactory(new PropertyValueFactory<Reservation,Date>("dateSortie"));
//                    clientCIN.setCellValueFactory(new PropertyValueFactory<Reservation,Client>("clientCIN"));
//                    parkingLibelle.setCellValueFactory(new PropertyValueFactory<Reservation,Parking>("parkingLibelle"));
//                    valide.setCellValueFactory(new PropertyValueFactory<Reservation,Boolean>("valide"));
//                   tableView.setItems(obList);
//                   tableView.getColumns().addAll(id,dateEntre,dateSortie, clientCIN, parkingLibelle, valide);
//                   tableView.setEditable(true);
//                                      
//
//                } else {
//                    System.out.println(rspns.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Reservation>> call, Throwable thrwbl) {
//                thrwbl.printStackTrace();
//            }
//        });
        client.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeAdminPage.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
