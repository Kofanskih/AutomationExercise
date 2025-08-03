package com.automationexercise.pageModels;

import lombok.Data;

@Data
public class LoginPageModel {
    private String userEmailAddress;
    private String userPassword;

    public LoginPageModel existUserLogin(){
        this.userEmailAddress = "1test1test@test.com";
        this.userPassword = "12345678";
        return this;
    }

    public LoginPageModel incorrectDataLogin(){
        this.userEmailAddress = "kofanskih08@gmail.com";
        this.userPassword = "1234567";
        return this;
    }
}
