package com.eltiempoes.rest.models.Provincias;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tomorrow {

    @SerializedName("p")
    @Expose
    private String p;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

}