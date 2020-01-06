package com.example.beerapp;

import com.example.beerapp.API.ApiService;
import com.example.beerapp.API.RetrofitConnector;
import com.example.beerapp.Model.BeerList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class BeerListConnector implements BeerListRepository {
    @Override
    public void getNetworkData() {
        Retrofit retrofit = RetrofitConnector.makeConnect();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<BeerList> beerList = apiService.getBeerList();
                beerList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();


    }
}
