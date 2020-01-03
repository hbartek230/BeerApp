package com.example.beerapp.API;

import com.example.beerapp.Model.BeerList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApiData {

    @GET("beers?key=a9c51c2b1c7f37337eff9f1a09aadc07")
    Call<List<BeerList>> getBeerList();
}
