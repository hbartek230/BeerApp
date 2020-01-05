package com.example.beerapp.API;

import com.example.beerapp.Model.BeerList;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("beers?key=a9c51c2b1c7f37337eff9f1a09aadc07")
    Observable<BeerList> getBeerList();
}
