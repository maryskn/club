package com.example.myapplication.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.DB.AppDataBase;
import com.example.myapplication.model.DB.User;
import com.example.myapplication.model.prefence.Myprefence;
import com.example.myapplication.model.remote.ApiRequest;
import com.example.myapplication.model.remote.RetrofitRequest;
import com.example.myapplication.model.remote.dto.LoginRequestModel;
import com.example.myapplication.model.remote.dto.LoginResponseModel;
import com.example.myapplication.model.remote.dto.RegisterRequestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Myrepository {
    Myprefence myprefence;
    private ApiRequest apiRequest;

    public Myrepository() {
        myprefence = new Myprefence();
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public void saveUser(User user) {
        AppDataBase.getAppDatabase().userDao().insert(user);
    }

    public LiveData<LoginResponseModel> login(String username, String password) {

        final MutableLiveData<LoginResponseModel> data = new MutableLiveData<>();
        apiRequest.userLogin(new LoginRequestModel(password, username))
                .enqueue(new Callback<LoginResponseModel>() {

                    @Override
                    public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                        Log.d("TAG", "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d("TAG", "result:: " + response.body().getResult());

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;

    }

    public LiveData<LoginResponseModel> Register(String phone, String name, String pass, String pass2) {

        final MutableLiveData<LoginResponseModel> data = new MutableLiveData<>();
        apiRequest.userRegister(new RegisterRequestModel(phone,name, pass,pass2))
                .enqueue(new Callback<LoginResponseModel>() {

                    @Override
                    public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                        Log.d("TAG", "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d("TAG", "result:: " + response.body().getResult());

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;

    }

    public List<User> getUser() {
        return AppDataBase.getAppDatabase().userDao().getAll();

    }
}
