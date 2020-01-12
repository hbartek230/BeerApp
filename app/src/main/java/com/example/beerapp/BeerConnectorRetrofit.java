package com.example.beerapp;

import android.util.Log;

import com.example.beerapp.api.BeerService;
import com.example.beerapp.api.RetrofitConnector;
import com.example.beerapp.Model.BeerList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class BeerConnectorRetrofit implements BeerRepositoryRetrofit {

    private static final String API_KEY = "key=a9c51c2b1c7f37337eff9f1a09aadc07";
    private static final String TAG = "BeerAplication";
    private Retrofit connector;
    private BeerService beerService;
    private Observable<BeerList> beerList;

    public BeerConnectorRetrofit(){

    }

    public BeerConnectorRetrofit(BeerService beerService){
        this.beerService = beerService;
    }
    @Override
    public Observable<BeerList> loadBeers() {
        connector = RetrofitConnector.createRetrofit(API_KEY);
        beerService = connector.create(BeerService.class);
        beerList = beerService.getBeerList();
                beerList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        Log.i(TAG, "Połączonon z Activity");
        return beerList;
    }
}
