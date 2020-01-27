package com.example.myapplication.model.prefence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.myapplication.MyApplication;


public class Myprefence {

    private SharedPreferences sharedPreferences;

    public Myprefence() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getMyApplication().getcontext());
    }

    public void saveToken(String token) {
        sharedPreferences.edit().putString("token", token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString("token", "");
    }

}
