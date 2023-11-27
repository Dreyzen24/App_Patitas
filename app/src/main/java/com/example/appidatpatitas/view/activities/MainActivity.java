package com.example.appidatpatitas.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appidatpatitas.R;
import com.example.appidatpatitas.databinding.ActivityMainBinding;
import com.example.appidatpatitas.retrofit.request.LoginRequest;
import com.example.appidatpatitas.retrofit.response.LoginResponse;
import com.example.appidatpatitas.view.activities.HomeActivity;
import com.example.appidatpatitas.view.activities.RegistroActivity;
import com.example.appidatpatitas.viewmodel.AuthViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        binding.btnregistro.setOnClickListener(this);
        binding.btningresar.setOnClickListener(this);
        authViewModel.loginResponseMutableLiveData
                .observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        validarLogin(loginResponse);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btningresar){
            invocarLogin();
        }else{
            startActivity(
                    new Intent(MainActivity.this,
                            RegistroActivity.class)
            );
        }
    }

    public void invocarLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsuario(binding.etusuario.getText().toString());
        loginRequest.setPassword(binding.etpassword.getText().toString());
        authViewModel.autenticarUsuario(loginRequest);
    }

    public void validarLogin(LoginResponse loginResponse){
        if(loginResponse.isRpta()){
            startActivity(new Intent(MainActivity.this,
                    HomeActivity.class));
        }else{
            Snackbar.make(binding.getRoot(),loginResponse.getMensaje(),Snackbar.LENGTH_LONG);
        }
    }
}