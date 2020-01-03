package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeerListActivity extends AppCompatActivity {

    private BeerListPresenter beerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list_activity);
        beerPresenter = new BeerListPresenter();
        System.out.println("\n\nTUTAJ JESTEM BARANIE\n\n");
        beerPresenter.viewCreated();
    }
}
