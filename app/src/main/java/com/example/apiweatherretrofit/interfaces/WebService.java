package com.example.apiweatherretrofit.interfaces;

import com.example.apiweatherretrofit.models.ModelCidades;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET ("data/2.5/weather?")
    Call <ModelCidades> webService (@Query("q") String cidade,
                                    @Query("appid") String API_KEY,
                                    @Query("lang") String idioma,
                                    @Query("units") String metric);
}


//https://api.openweathermap.org/
// data/2.5/weather?
// q=Agrestina&
// appid=70c7006c98c1a2e32a1cdb95e763da0f&
// lang=pt_br&
// units=metric
