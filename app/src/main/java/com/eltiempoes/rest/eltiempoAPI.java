package com.eltiempoes.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class eltiempoAPI {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.el-tiempo.net/api/json/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    private static Eltiempo service = retrofit.create(Eltiempo.class);

    public static synchronized Eltiempo getInstance() {
        if (service == null)
            service = retrofit.create(Eltiempo.class);
        return service;
    }
}
