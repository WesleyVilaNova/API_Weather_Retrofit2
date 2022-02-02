package com.example.apiweatherretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCidades {

    @SerializedName("name")
    @Expose
    private String cidade;


    @SerializedName("sys")
    private Sys sys;

    @SerializedName("main")
    private Main main;

    public ModelCidades(String cidade, Sys sys, Main main) {
        this.cidade = cidade;
        this.sys = sys;
        this.main = main;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
