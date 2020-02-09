package com.example.beerapp;

import android.util.Log;

import com.example.beerapp.api.BeerService;
import com.example.beerapp.Model.Beers;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BeerConnector implements BeerRepository {

    private static final String TAG = "BeerAplication";
    private BeerService beerService;
    private Observable<Beers> beerList;

    public BeerConnector(BeerService beerService) {
        this.beerService = beerService;
    }

    @Override
    public Observable<Beers> loadBeers() {
        beerList = beerService.getBeerList();
        beerList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        Log.i(TAG, "Połączonon z Activity");
        return beerList;
    }
}
