package com.eltiempoes.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ciudade {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idProvince")
    @Expose
    private String idProvince;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameProvince")
    @Expose
    private String nameProvince;
    @SerializedName("stateSky")
    @Expose
    private StateSky stateSky;
    @SerializedName("temperatures")
    @Expose
    private Temperatures temperatures;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(String idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public StateSky getStateSky() {
        return stateSky;
    }

    public void setStateSky(StateSky stateSky) {
        this.stateSky = stateSky;
    }

    public Temperatures getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

}