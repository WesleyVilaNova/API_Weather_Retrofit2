package com.example.apiweatherretrofit.models;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp_max")
    private Double tempMax;

    @SerializedName("temp_min")
    private Double tempMin;

    @SerializedName("humidity")
    private Double humidade;

    public Main(Double tempMax, Double tempMin, Double humidade) {
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.humidade = humidade;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getHumidade() {
        return humidade;
    }
}
