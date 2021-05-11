package com.eltiempoes.rest.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateSky {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private String id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}