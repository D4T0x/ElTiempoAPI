package com.eltiempoes.rest.models.Provincias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comautonoma {

    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("CODAUTON")
    @Expose
    private String codauton;
    @SerializedName("CODCOMUN")
    @Expose
    private String codcomun;
    @SerializedName("NOMBRE")
    @Expose
    private String nombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodauton() {
        return codauton;
    }

    public void setCodauton(String codauton) {
        this.codauton = codauton;
    }

    public String getCodcomun() {
        return codcomun;
    }

    public void setCodcomun(String codcomun) {
        this.codcomun = codcomun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}