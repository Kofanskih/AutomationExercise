package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement SIGN_UP_NAME_FIELD = $("[data-qa=\"signup-name\"]");
    private final SelenideElement EMAIL_ADDRESS_FIELD = $("[data-qa=\"signup-email\"]");
    private final SelenideElement SIGNUP_BUTTON = $("[data-qa=\"signup-button\"]");
    private final SelenideElement LOGIN_EMAIL_ADDRESS_FIELD = $("[data-qa=\"login-email\"]");
    private final SelenideElement PASSWORD_FIELD = $("[data-qa=\"login-password\"]");
    private final SelenideElement LOGIN_BUTTON = $("[data-qa=\"login-button\"]");

    public SignUpPage fillSignUpForm(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserFirstName());
        EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return new SignUpPage();
    }

    public MainPage fillLoginForm(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new MainPage();
    }
}
