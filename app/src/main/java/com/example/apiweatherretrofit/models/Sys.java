package com.example.apiweatherretrofit.models;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country")
    private String pais;

    public Sys(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }
}
