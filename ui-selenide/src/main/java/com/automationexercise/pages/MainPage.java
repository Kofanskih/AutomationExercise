package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement ACCEPT_COOKIES_BUTTON = $("[class=\"fc-button-label\"]");
    private final SelenideElement USER_LOGGED_IN_TEXT = $("[href=\"/logout\"]");
    private final SelenideElement LOGIN_ERROR_TEXT = $("[style=\"color: red;\"]");

    public MainPage acceptCookies(){
        ACCEPT_COOKIES_BUTTON.click();
        return new MainPage();
    }

    public MainPage checkUserLoggedIn(String loggedInText){
        USER_LOGGED_IN_TEXT.shouldHave(Condition.exactTextCaseSensitive(loggedInText));
        return this;
    }

    public MainPage checkLoginErrorMessage(String loginErrorMessage){
        LOGIN_ERROR_TEXT.shouldHave(Condition.exactTextCaseSensitive(loginErrorMessage));
        return this;
    }


}
