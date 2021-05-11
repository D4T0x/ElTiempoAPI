package com.eltiempoes.rest.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ciudades")
    @Expose
    private List<Ciudade> ciudades = null;
    @SerializedName("today")
    @Expose
    private Today today;
    @SerializedName("tomorrow")
    @Expose
    private Tomorrow tomorrow;
    @SerializedName("provincias")
    @Expose
    private List<Provincia> provincias = null;
    @SerializedName("breadcrumb")
    @Expose
    private List<Object> breadcrumb = null;
    @SerializedName("metadescripcion")
    @Expose
    private String metadescripcion;
    @SerializedName("keywords")
    @Expose
    private String keywords;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ciudade> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudade> ciudades) {
        this.ciudades = ciudades;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    public Tomorrow getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(Tomorrow tomorrow) {
        this.tomorrow = tomorrow;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Object> getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(List<Object> breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public String getMetadescripcion() {
        return metadescripcion;
    }

    public void setMetadescripcion(String metadescripcion) {
        this.metadescripcion = metadescripcion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}