package com.example.beerapp.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnector {
    private static final String BEER_SERVICE_URL = "https://sandbox-api.brewerydb.com/v2";
    private static Retrofit connector;
    private static RetrofitInterceptor interceptor;

    public static Retrofit createRetrofit(final String API_KEY) {
        if (connector == null) {
            interceptor = new RetrofitInterceptor(API_KEY);
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
            connector = new Retrofit.Builder()
                    .baseUrl(BEER_SERVICE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return connector;
    }

    private RetrofitConnector() {
    }
}
