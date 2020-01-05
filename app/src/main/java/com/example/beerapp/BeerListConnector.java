package com.example.beerapp;

import com.example.beerapp.API.ApiService;
import com.example.beerapp.Model.BeerList;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeerListConnector implements BeerListRepository {
    @Override
    public void getNetworkData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox-api.brewerydb.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<BeerList> beerList = apiService.getBeerList();
    }
}
