package com.automationexercise.pageModels;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class LoginPageModel {
    private String userEmailAddress;
    private String userPassword;

    @Step("Use correct login")
    public LoginPageModel myLogin(){
        this.userEmailAddress = "1test1test@test.com";
        this.userPassword = "12345678";
        return this;
    }

    @Step("Use incorrect login")
    public LoginPageModel incorrectDataLogin(){
        this.userEmailAddress = "1test1test@test.com";
        this.userPassword = "1234567";
        return this;
    }
}
