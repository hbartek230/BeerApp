package com.example.beerapp;

public class BeerListPresenter implements BeerListMVPContract.Presenter {

    private final RetrofitBeerListRepository repository;

    public BeerListPresenter(RetrofitBeerListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void viewCreated() {
        loadBeers();
    }

    private void loadBeers() {
        repository.loadBeers();

    }
}
