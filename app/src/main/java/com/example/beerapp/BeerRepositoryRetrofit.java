package com.example.beerapp;

import com.example.beerapp.Model.BeerList;

import io.reactivex.Observable;

public interface BeerRepositoryRetrofit {

    Observable<BeerList> loadBeers();
}
