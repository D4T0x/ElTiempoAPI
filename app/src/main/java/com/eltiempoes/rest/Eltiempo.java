package com.eltiempoes.rest;

import com.eltiempoes.rest.models.Example;
import com.eltiempoes.rest.models.Provincias.ExampleProv;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Eltiempo {
    @GET("home")
    Observable <Example> getHome();

    @GET("provincias/{CODPROV}")
    Observable <ExampleProv> getProv(@Path("CODPROV") String CODPROV);

}
