package com.example.myapplication.view.main;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.DB.User;
import com.example.myapplication.model.Myrepository;
import com.example.myapplication.view.main.Main.SignIn;

import java.util.List;

public class MyViewModel extends ViewModel {
    Myrepository myrepository;
    SignIn signIn;

    public MyViewModel() {
        signIn = null;
        myrepository = new Myrepository();
    }

    public void login(String username,String password) {
        if(username.equals("")||password.equals(""))
        {
            signIn.onError("لطفا اطلاعات را وارد کنید");
            return;
        }
        else
        {
            signIn.onSuccess("خوش آمدید");
            myrepository.login(username,password);
        }

    }

    public List<User> getUser() {
        return myrepository.getUser();
    }


}
