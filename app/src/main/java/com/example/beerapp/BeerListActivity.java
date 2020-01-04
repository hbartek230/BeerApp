package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.beerapp.Model.BeerList;

public class BeerListActivity extends AppCompatActivity {

    private BeerListPresenter beerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list_activity);
        beerPresenter = new BeerListPresenter(new BeerListConnector());
        beerPresenter.viewCreated();
    }
}
