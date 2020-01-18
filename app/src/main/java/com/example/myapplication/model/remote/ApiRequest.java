package com.example.myapplication.model.remote;

import com.example.myapplication.model.remote.dto.LoginRequestModel;
import com.example.myapplication.model.remote.dto.LoginResponseModel;
import com.example.myapplication.model.remote.dto.RegisterRequestModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiRequest {

    @Headers({"Accept: application/json"})
    @POST("user/login")
    Call<LoginResponseModel> userLogin(@Body LoginRequestModel loginRequestModel);

    @Headers({"Accept: application/json"})
    @POST("user/first-login")
    Call<LoginResponseModel> userRegister(@Body RegisterRequestModel registerRequestModel);


}
