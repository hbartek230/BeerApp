package com.example.beerapp;

import com.example.beerapp.API.GetApiData;
import com.example.beerapp.Model.BeerList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeerListPresenter implements BeerListMVPContract.Presenter {
    @Override
    public void viewCreated() {
        getNetworkData();
    }

    private void getNetworkData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox-api.brewerydb.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetApiData getApiData = retrofit.create(GetApiData.class);
        Call<List<BeerList>> call = getApiData.getBeerList();

        //System.out.println("\n\nTU COŚ SIĘ DZIEJE: " + call.toString());

      call.enqueue(new Callback<List<BeerList>>() {
            @Override
            public void onResponse(Call<List<BeerList>> call, Response<List<BeerList>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("\n\nJest tu jakiś problem\n\n");
                } else {
                    System.out.println("\n\nPołączono z sukcesem\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<BeerList>> call, Throwable t) {
                System.out.println("\n\nJAKIŚ BŁĄD: "+ t.getMessage());
            }
        });
    }
}
