package com.example.beerapp.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnector {

    private static Retrofit connector;

    private RetrofitConnector(){

    }

    public static Retrofit makeConnect() {

        connector = new Retrofit.Builder()
                .baseUrl("https://sandbox-api.brewerydb.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return connector;
    }
}
