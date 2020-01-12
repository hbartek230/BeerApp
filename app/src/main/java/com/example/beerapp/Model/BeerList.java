package com.example.beerapp.Model;

import com.google.gson.annotations.SerializedName;

public class BeerList {

    @SerializedName("id")
    private String beerId;
    @SerializedName("nameDisplay")
    private String beerNme;
    @SerializedName("description")
    private String beerDescription;

    public String getBeerId() {
        return beerId;
    }

    public String getBeerNme() {
        return beerNme;
    }

    public String getBeerDescription() {
        return beerDescription;
    }
}
