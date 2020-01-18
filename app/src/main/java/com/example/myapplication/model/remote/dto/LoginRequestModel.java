package com.example.myapplication.model.remote.dto;

public class LoginRequestModel {

    private String password;
    private String username;

    public LoginRequestModel(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}