package com.example.myapplication.view;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.DB.User;
import com.example.myapplication.model.Myrepository;
import com.example.myapplication.view.Main.SignIn;

import java.util.List;

public class MyViewModel extends ViewModel {
   public Myrepository myrepository;
   public SignIn signIn;

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
