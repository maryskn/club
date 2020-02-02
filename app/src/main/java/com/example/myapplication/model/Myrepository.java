package com.example.myapplication.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.db.AppDataBase;
import com.example.myapplication.model.db.User;
import com.example.myapplication.model.prefence.Myprefence;
import com.example.myapplication.model.remote.ApiRequest;
import com.example.myapplication.model.remote.RetrofitRequest;
import com.example.myapplication.model.remote.dto.LoginRequestModel;
import com.example.myapplication.model.remote.dto.RegisterRequestModel;

import java.util.List;

import okhttp3.ResponseBody;
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

    public LiveData<Response<ResponseBody>> login(String username, String password) {

        final MutableLiveData<Response<ResponseBody>> data = new MutableLiveData<>();

        apiRequest.userLogin(new LoginRequestModel(password, username))
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response != null) {
                            data.setValue(response);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;

    }

    public LiveData<Response<ResponseBody>> Register(String phone, String nationalcode, String pass, String pass2) {

        final MutableLiveData<Response<ResponseBody>> data1 = new MutableLiveData<>();
        apiRequest.userRegister(new RegisterRequestModel(phone, nationalcode, pass, pass2))
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.w("TAG", "onResponse response:: " + response);

                        if (response.body() != null) {
                            data1.setValue(response);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        data1.setValue(null);
                        Log.w("TAG", "result:: ");
                    }
                });
        return data1;

    }

    public List<User> getUser() {
        return AppDataBase.getAppDatabase().userDao().getAll();

    }

    public void saveToken(String token) {
        myprefence.saveToken(token);
    }

    public String getToken() {
        return myprefence.getToken();
    }
}
