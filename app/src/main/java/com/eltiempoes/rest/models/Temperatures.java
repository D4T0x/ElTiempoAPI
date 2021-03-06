package com.eltiempoes.rest.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Temperatures {

    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("min")
    @Expose
    private String min;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

}
