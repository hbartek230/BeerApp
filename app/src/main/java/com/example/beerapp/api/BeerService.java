package com.example.beerapp.api;

import com.example.beerapp.Model.BeerList;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BeerService {

    @GET("beers")
    Observable<BeerList> getBeerList();
}
