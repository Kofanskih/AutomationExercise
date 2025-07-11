package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage{
    private final SelenideElement SIGN_UP_NAME_FIELD = $("[data-qa=\"signup-name\"]");
    private final SelenideElement SIGNUP_EMAIL_ADDRESS_FIELD = $("[data-qa=\"signup-email\"]");
    private final SelenideElement SIGNUP_BUTTON = $("[data-qa=\"signup-button\"]");
    private final SelenideElement LOGIN_EMAIL_ADDRESS_FIELD = $("[data-qa=\"login-email\"]");
    private final SelenideElement PASSWORD_FIELD = $("[data-qa=\"login-password\"]");
    private final SelenideElement LOGIN_BUTTON = $("[data-qa=\"login-button\"]");


    public SignUpPage fillSignUpForm(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserFirstName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return new SignUpPage();
    }

    public MainPage fillLoginForm(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new MainPage();
    }

    public SignUpPage fillSignUpFormWithExistsUser(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return new SignUpPage();
    }

    public LoginPage fillLoginFormWithEmptyEmailField(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.clear();
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    public void checkShowValidationMessageWhenLoginEmailIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", LOGIN_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    public LoginPage fillLoginFormWithEmptyPasswordField(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.clear();
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    public void checkShowValidationMessageWhenPasswordIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", PASSWORD_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }


    public LoginPage fillLoginFormWithInvalidEmail(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    public void checkShowValidationMessageWhenLoginEmailIsInvalid(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", LOGIN_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    public LoginPage fillSignUpFormWithEmptyNameField(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.clear();
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return this;
    }

    public void checkShowValidationMessageWhenSignUpNameIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGN_UP_NAME_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    public LoginPage fillSignUpFormWithEmptyEmailField(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.clear();
        SIGNUP_BUTTON.click();

        return this;
    }

    public void checkShowValidationMessageWhenSignUpEmailIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGNUP_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    public LoginPage fillSignUpFormWithInvalidEmail(RegistrationPageModel registrationPageModel){
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    public void checkShowValidationMessageWhenSignUpEmailIsInvalid(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGNUP_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

}
