package com.example.myapplication.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Myrepository;
import com.example.myapplication.model.db.User;
import com.example.myapplication.ui.Auth.SignIn;
import com.example.myapplication.ui.Auth.Verification;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    public Myrepository myrepository;
    public SignIn signIn;
    public Verification verification;
    private LiveData<Response<ResponseBody>> loginResponseModelLiveData;
    private LiveData<Response<ResponseBody>> registerResponseModelLiveData;

    public MyViewModel() {
        signIn = null;
        verification = null;
        myrepository = new Myrepository();
    }

    public void login(String username, String password) {
        if (username.equals("") || password.equals("")) {
            signIn.onError("لطفا اطلاعات را وارد کنید");
            return;
        } else {
            //signIn.onSuccess("خوش آمدید");
            this.loginResponseModelLiveData = myrepository.login(username, password);
        }
    }


    public LiveData<Response<ResponseBody>> getLoginResponseModelLiveData() {
        return loginResponseModelLiveData;
    }

    public void Register(String phone, String nationalcode, String pass, String pass2) {

        if (phone.equals("") || nationalcode.equals("") || pass.equals("") || pass2.equals("")) {
            verification.onError("لطفا اطلاعات را وارد کنید");
            return;
        }

        if (phone.length() != 11) {
            verification.onError("شماره تلفن همراه را درست وارد نمایید");
            return;
        }

        if (!pass.equals(pass2)) {
            verification.onError("رمز عبور را صحیح وارد نمایید");
            return;
        }

        //verification.onSuccess("کد فعال سازی ارسال شد");
        this.registerResponseModelLiveData = myrepository.Register(phone, nationalcode, pass, pass2);


    }

    public LiveData<Response<ResponseBody>> getRegisterResponseModelLiveData() {
        return registerResponseModelLiveData;
    }

    public List<User> getUser() {
        return myrepository.getUser();
    }


    public void saveToken(String token) {
        myrepository.saveToken(token);
    }

    public String getToken() {
        return myrepository.getToken();
    }

}
