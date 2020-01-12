package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.beerapp.api.BeerService;

import butterknife.BindView;

public class BeerListActivity extends AppCompatActivity {

    @BindView(R.id.beerList)
    RecyclerView beerListRecycler;
    private BeerListPresenter beerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list_activity);
//        beerListRecycler.setLayoutManager(new LinearLayoutManager(this));
        beerPresenter = new BeerListPresenter(new BeerListConnector());
        beerPresenter.viewCreated();
    }
}
