package com.example.myapplication.model.remote;


import com.example.myapplication.model.remote.dto.LoginRequestModel;
import com.example.myapplication.model.remote.dto.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiRequest {

    @POST("user/login")
    Call<LoginResponseModel> userLogin(@Body LoginRequestModel loginRequestModel);
}
