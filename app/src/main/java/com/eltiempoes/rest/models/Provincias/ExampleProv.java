package com.eltiempoes.rest.models.Provincias;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleProv {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("today")
    @Expose
    private Today today;
    @SerializedName("tomorrow")
    @Expose
    private Tomorrow tomorrow;
    @SerializedName("ciudades")
    @Expose
    private List<Ciudade> ciudades = null;
    @SerializedName("provincia")
    @Expose
    private Provincia provincia;
    @SerializedName("comautonoma")
    @Expose
    private Comautonoma comautonoma;
    @SerializedName("breadcrumb")
    @Expose
    private List<Breadcrumb> breadcrumb = null;
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

    public List<Ciudade> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudade> ciudades) {
        this.ciudades = ciudades;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Comautonoma getComautonoma() {
        return comautonoma;
    }

    public void setComautonoma(Comautonoma comautonoma) {
        this.comautonoma = comautonoma;
    }

    public List<Breadcrumb> getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(List<Breadcrumb> breadcrumb) {
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