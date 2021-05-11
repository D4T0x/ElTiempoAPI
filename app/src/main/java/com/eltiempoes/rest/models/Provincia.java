package com.eltiempoes.rest.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provincia {

    @SerializedName("CODPROV")
    @Expose
    private String codprov;
    @SerializedName("NOMBRE_PROVINCIA")
    @Expose
    private String nombreProvincia;
    @SerializedName("CODAUTON")
    @Expose
    private String codauton;
    @SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
    @Expose
    private String comunidadCiudadAutonoma;
    @SerializedName("CAPITAL_PROVINCIA")
    @Expose
    private String capitalProvincia;

    public String getCodprov() {
        return codprov;
    }

    public void setCodprov(String codprov) {
        this.codprov = codprov;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getCodauton() {
        return codauton;
    }

    public void setCodauton(String codauton) {
        this.codauton = codauton;
    }

    public String getComunidadCiudadAutonoma() {
        return comunidadCiudadAutonoma;
    }

    public void setComunidadCiudadAutonoma(String comunidadCiudadAutonoma) {
        this.comunidadCiudadAutonoma = comunidadCiudadAutonoma;
    }

    public String getCapitalProvincia() {
        return capitalProvincia;
    }

    public void setCapitalProvincia(String capitalProvincia) {
        this.capitalProvincia = capitalProvincia;
    }

}