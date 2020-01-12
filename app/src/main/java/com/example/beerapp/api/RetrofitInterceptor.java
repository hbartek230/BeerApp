package com.example.beerapp.api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitInterceptor implements Interceptor {

    private String API_KEY;

    public RetrofitInterceptor (String API_KEY){
        this.API_KEY = API_KEY;
    }
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("api_key", API_KEY)
                .build();
        return chain.proceed(request);
    }
}
