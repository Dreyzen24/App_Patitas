package com.example.appidatpatitas.retrofit;

import com.example.appidatpatitas.retrofit.request.LoginRequest;
import com.example.appidatpatitas.retrofit.request.RegistroRequest;
import com.example.appidatpatitas.retrofit.response.LoginResponse;
import com.example.appidatpatitas.retrofit.response.MascotaResponse;
import com.example.appidatpatitas.retrofit.response.RegistroResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PatitasServicio {

    @POST("login.php")
    Call<LoginResponse> login (@Body LoginRequest loginRequest);

    @PUT("persona.php")
    Call<RegistroResponse> registro(@Body RegistroRequest registroRequest);

    @GET("mascotaperdida.php")
    Call<List<MascotaResponse>> listarMascota();

}

