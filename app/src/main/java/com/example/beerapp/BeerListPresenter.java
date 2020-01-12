package com.example.beerapp;

public class BeerListPresenter implements BeerListMVPContract.Presenter {

    private final BeerRepositoryRetrofit repository;

    public BeerListPresenter(BeerRepositoryRetrofit repository) {
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
