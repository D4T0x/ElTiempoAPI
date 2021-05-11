package com.eltiempoes.rest.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tomorrow {

    @SerializedName("p")
    @Expose
    private List<String> p = null;

    public List<String> getP() {
        return p;
    }

    public void setP(List<String> p) {
        this.p = p;
    }

}