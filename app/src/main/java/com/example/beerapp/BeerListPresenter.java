package com.example.beerapp;

public class BeerListPresenter implements BeerListMVPContract.Presenter {

    private final BeerRepository repository;

    public BeerListPresenter(BeerRepository repository) {
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
