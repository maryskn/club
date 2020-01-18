package com.example.myapplication.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.DB.User;
import com.example.myapplication.model.Myrepository;
import com.example.myapplication.model.remote.dto.LoginResponseModel;
import com.example.myapplication.view.Main.SignIn;
import com.example.myapplication.view.Main.Verification;

import java.util.List;

public class MyViewModel extends ViewModel {
    public Myrepository myrepository;
    public SignIn signIn;
    public Verification verification;
    private LiveData<LoginResponseModel> loginResponseModelLiveData;

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

    public LiveData<LoginResponseModel> getLoginResponseModelLiveData() {
        return loginResponseModelLiveData;
    }

    public void sendMessage(String phone, String name, String pass, String pass2) {
        if (phone.equals("") || name.equals("") || pass.equals("") || pass2.equals("")) {
            verification.onError("لطفا اطلاعات را وارد کنید");
            return;
        } else {
            verification.onSuccess("کد فعال سازی ارسال شد");

        }
    }

    public List<User> getUser() {
        return myrepository.getUser();
    }


}
