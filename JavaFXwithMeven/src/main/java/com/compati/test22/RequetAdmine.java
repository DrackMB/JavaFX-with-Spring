/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compati.test22;

import com.GestionDeParking.bean.Administrateur;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author dell
 */
public interface RequetAdmine {

    @GET("GestionDeParking/Admin/user/{users}")
    public Call<Administrateur> findByLogin(@Path("users") String user);

}
