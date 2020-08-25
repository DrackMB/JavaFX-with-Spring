package com.GestionDeParking.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Administrateur {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("mdp")
    @Expose
    private String mdp;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Administrateur(String login, String mdp, String type) {
        this.login = login;
        this.mdp = mdp;
        this.type = type;
    }
    

}
