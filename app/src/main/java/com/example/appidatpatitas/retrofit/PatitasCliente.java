package com.example.appidatpatitas.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatitasCliente {

    private static final String BASE_URL="http://www.kreapps.biz/patitas/";
    private PatitasServicio patitasServicio;
    public PatitasCliente() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        patitasServicio  = retrofit.create(PatitasServicio.class);

    }

    public PatitasServicio getInstance() {
        return  patitasServicio;
    }

}
