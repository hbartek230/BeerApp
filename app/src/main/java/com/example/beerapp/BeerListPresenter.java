package com.example.beerapp;

public class BeerListPresenter implements BeerListMVPContract.Presenter {

    private final BeerListRepository repository;

    public BeerListPresenter(BeerListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void viewCreated() {
        getNetworkData();
    }

    private void getNetworkData() {
        repository.getNetworkData();

    }
}
