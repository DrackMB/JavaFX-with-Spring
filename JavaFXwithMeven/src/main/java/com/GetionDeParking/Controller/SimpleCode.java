/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GetionDeParking.Controller;

/**
 *
 * @author dell
 */
public class SimpleCode {
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
    
    
    //-----------------------------------------------------------------------
    // clientid.cellValueFactoryProperty(new PropertyValueFactory<Long,Long>("clientCIN"));
                    //clientCIN.getColumns().addAll(clientid,numCIN,numMatricule,numTele);

//                    id.setText(String.valueOf(changesList.getId()));
//                    dateEntre.setText(String.valueOf(changesList.getDateEntre()));
//                    dateSortie.setText(String.valueOf(changesList.getDateSortie()));
                    //clientCIN.setText(changesList.getClient().getNumCIN());
    
    
    
    
//    
//     UserService gerritAPI = retrofit.create(UserService.class);
//        Call<Reservation> call2 = gerritAPI.getReservation("g123");
//        call2.enqueue(new Callback<Reservation>() {
//            @Override
//            public void onResponse(Call<Reservation> call, Response<Reservation> rspns) {
//                if (rspns.isSuccessful()) {
//                    Reservation changesList = rspns.body();
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
//                        System.out.println(changesList);
//                        
//                    }
//
//                 else {
//                    System.out.println(rspns.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Reservation> call, Throwable thrwbl) {
//                thrwbl.printStackTrace();
//            }
//        });
//;
//    
    
    
//    
//        @FXML
//    private TableView<Reservation> tableView;
//    @FXML
//    private TableColumn<Reservation,Long> id;
//   
//    //matricules.setCellValueFactory(new PropertyValueFactory<JoinEncadrement, String>("matricule"));
//    @FXML
//    private TableColumn<Reservation,Date> dateEntre;
//    @FXML
//    private TableColumn<Reservation,Date> dateSortie;
//    
//    @FXML
//    private TableColumn<Reservation,Parking> parkingLibelle;
//    @FXML
//    private TableColumn<Reservation,Boolean> valide;
//    //--------------------------------------------------
//    @FXML
//    private TableColumn<Reservation,Client> clientCIN;
////    @FXML
////    private TableColumn<Long,Client> clientid;
////    @FXML
////    private TableColumn<Client,String> numCIN;
////    @FXML
////    private TableColumn<Client,String> numMatricule;
////    @FXML
////    private TableColumn<Client,String> numTele;
////    //--------------------------------------
////    @FXML
////    private TableColumn<Parking,String> liblle;
////    @FXML
////    private TableColumn<Parking,String> adress;
////    @FXML
////    private TableColumn<Parking,Long> Parid;
//    
//    
//    //id.cellValueFactoryProperty(new PropertyValueFactory<>);
    
//    
//     <TableView fx:id="tableView" editable="true" layoutY="186.0" prefHeight="200.0" prefWidth="783.0">
//        <columns>
//          <TableColumn fx:id="id" prefWidth="75.0" text="id" />
//          <TableColumn fx:id="dateEntre" prefWidth="104.80001220703124" text="dateEntre" />
//            <TableColumn fx:id="dateSortie" prefWidth="75.0" text="dateSortie" />
//            <TableColumn fx:id="clientCIN" prefWidth="75.0" text="clientCIN" />
//              <!-- <columns>
//                  <TableColumn fx:id="numCIN" prefWidth="75.0" text="numCIN" />
//                  <TableColumn fx:id="numMatricule" prefWidth="75.0" text="numMatricule" />
//                  <TableColumn fx:id="numTele" prefWidth="75.0" text="numTele" />
//                  <TableColumn fx:id="clientid" prefWidth="75.0" text="id" />
//               </columns>-->
//            
//            <TableColumn fx:id="parkingLibelle" prefWidth="75.0" text="parkingLibelle" />
//              <!-- <columns>
//                  <TableColumn fx:id="liblle" prefWidth="75.0" text="liblle" />
//                  <TableColumn fx:id="Adress" prefWidth="75.0" text="Adress" />
//                  <TableColumn fx:id="Parid" prefWidth="75.0" text="id" />
//               </columns>-->
//               
//            <TableColumn fx:id="valide" prefWidth="75.0" text="valide" />
//        </columns>
//         <columnResizePolicy>
//            <TableView fx:constant="CONSTRAINED_RESIZE_POLICY" />
//         </columnResizePolicy>
//      </TableView>
}
