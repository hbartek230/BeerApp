package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.beerapp.api.BeerService;
import com.example.beerapp.api.RetrofitConnector;

import butterknife.BindView;
import retrofit2.Retrofit;

public class BeerListingActivity extends AppCompatActivity {

    private static final String API_KEY = "key=a9c51c2b1c7f37337eff9f1a09aadc07";

    @BindView(R.id.beerList)
    RecyclerView beerListRecycler;

    private BeerListPresenter beerPresenter;
    private BeerService beerService;
    private Retrofit connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list_activity);
        beerListRecycler.setLayoutManager(new LinearLayoutManager(this));
        getConnector();
        beerPresenter = new BeerListPresenter(new BeerConnector(beerService));
        beerPresenter.viewCreated();
    }

    private void getConnector() {
        connector = RetrofitConnector.createRetrofit(API_KEY);
        this.beerService = connector.create(BeerService.class);
    }
}
