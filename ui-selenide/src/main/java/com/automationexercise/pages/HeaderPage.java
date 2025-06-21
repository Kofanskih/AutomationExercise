package com.automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement LOGO = $("[alt=\"Website for automation practice\"]");
    private final SelenideElement HOME_BUTTON = $("[class=\"fa fa-home\"]");
    private final SelenideElement LOGIN_BUTTON = $("[class=\"fa fa-lock\"]");

    public MainPage clickLogo(){
        LOGO.click();
        return new MainPage();
    }

    public MainPage clickHomeButton(){
        HOME_BUTTON.click();
        return new MainPage();
    }

    public LoginPage clickLoginButton(){
        LOGIN_BUTTON.click();
        return new LoginPage();
    }
}
