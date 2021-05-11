package com.eltiempoes.rest;

import com.eltiempoes.rest.models.Ciudade;
import com.eltiempoes.rest.models.Example;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface Eltiempo {
    @GET("home")
    Observable <Example> getHome();

}
