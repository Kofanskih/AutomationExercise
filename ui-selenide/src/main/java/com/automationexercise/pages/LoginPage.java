package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement SIGN_UP_NAME_FIELD = $("[data-qa=\"signup-name\"]");
    private final SelenideElement EMAIL_ADDRESS_FIELD = $("[data-qa=\"signup-email\"]");
    private final SelenideElement SIGNUP_BUTTON = $("[data-qa=\"signup-button\"]");

    public SignUpPage fillSignUpForm(RegistrationPageModel registrationPageModel){
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserFirstName());
        EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();
        return new SignUpPage();
    }
}
