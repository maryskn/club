package com.example.myapplication.model.remote.dto;

public class RegisterRequestModel {

    private String mobileNumber;
    private String nationalCode;
    private String password;
    private String repassword;

    public RegisterRequestModel(String mobileNumber, String nationalCode, String password, String repassword) {
        this.mobileNumber = mobileNumber;
        this.nationalCode = nationalCode;
        this.password = password;
        this.repassword = repassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public String getRepassword() {
        return repassword;
    }
}
