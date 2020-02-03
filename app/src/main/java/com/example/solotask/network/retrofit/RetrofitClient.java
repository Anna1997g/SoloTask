package com.example.solotask.network.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitClient {
    private static final String BASE_URL = "https://content.guardianapis.com/";
    private static  RetrofitClient instance = null;
    private RequestApiService requestApiService;

    private RetrofitClient(){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestApiService = retrofit.create(RequestApiService.class);

    }

    public RequestApiService getRequestApiService() {
        return requestApiService;
    }
    public static RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }
}
