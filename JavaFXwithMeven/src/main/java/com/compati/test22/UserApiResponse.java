/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compati.test22;

import com.GestionDeParking.bean.Reservation;
import java.util.List;


public class UserApiResponse {
    private List <Reservation> data;

    public List<Reservation> getData() {
        return data;
    }

    public void setData(List<Reservation> data) {
        this.data = data;
    }

   
    
 
    //Setters and getters

    @Override
    public String toString() {
        return "UserApiResponse{" + "data=" + data + '}';
    }
 
    
}
