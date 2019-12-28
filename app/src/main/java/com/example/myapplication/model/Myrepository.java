package com.example.myapplication.model;

import com.example.myapplication.model.DB.AppDataBase;
import com.example.myapplication.model.DB.User;
import com.example.myapplication.model.prefence.Myprefence;
import java.util.List;

public class Myrepository {
    Myprefence myprefence;

    public Myrepository() {
        myprefence = new Myprefence();
    }

    public void saveUser(User user) {
        AppDataBase.getAppDatabase().userDao().insert(user);
    }

    public void login(String username,String password) {
       //TODO call login service
    }

    public List<User> getUser() {
        return AppDataBase.getAppDatabase().userDao().getAll();

    }
}
