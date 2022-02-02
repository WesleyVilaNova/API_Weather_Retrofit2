package com.example.apiweatherretrofit.repository;

import com.example.apiweatherretrofit.interfaces.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    private Retrofit retrofit;
    private String BASE_URL = "https://api.openweathermap.org/";

    public ConfigRetrofit(Retrofit retrofit) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

public WebService getCidades (){
    return this.retrofit.create(WebService.class);
    }
}


//https://api.openweathermap.org/data/2.5/weather?q=Agrestina&appid=70c7006c98c1a2e32a1cdb95e763da0f&lang=pt_br&units=metric
