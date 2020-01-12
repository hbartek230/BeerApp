package com.example.beerapp.api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnector {
    private static final String BEER_SERVICE_URL = "https://sandbox-api.brewerydb.com/v2";
    private static Retrofit connector;

    public static Retrofit createRetrofit(final String API_KEY) {
        if (connector == null) {
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("api_key", API_KEY)
                            .build();
                    return chain.proceed(request);
                }
            }).build();
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
