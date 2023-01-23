package com.example.api.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "http://34.231.88.85:8001/api/";
    private static RetrofitClient retrofitClint;
    private static Retrofit retrofit;
    public static API api;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClint == null) {
            retrofitClint = new RetrofitClient();
            api = retrofit.create(API.class);
        }
        return retrofitClint;
    }

    public API getApi() {
        return retrofit.create(API.class);
    }
}
