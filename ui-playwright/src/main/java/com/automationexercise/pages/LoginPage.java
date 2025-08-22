package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends BasePage{
    private final String LOGIN_EMAIL_ADDRESS_FIELD = "input[name='email']";
    private final String PASSWORD_FIELD = "input[name='password']";
    private final String LOGIN_BUTTON = "button[data-qa='login-button']";

    public LoginPage(Page page) {
        super(page);
    }

    @Step("Fill login form and click login button")
    public MainPage fillLoginForm(LoginPageModel loginPageModel){
        page.fill(LOGIN_EMAIL_ADDRESS_FIELD, loginPageModel.getUserEmailAddress());
        page.fill(PASSWORD_FIELD, loginPageModel.getUserPassword());
        page.click(LOGIN_BUTTON);

        return new MainPage(page);
    }
}
