package com.example.beerapp;

import com.example.beerapp.Model.Beers;

import io.reactivex.Observable;

public interface BeerRepository {

    Observable<Beers> loadBeers();
}
