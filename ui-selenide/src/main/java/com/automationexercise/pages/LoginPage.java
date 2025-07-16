package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
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

    @Step ("Fiil sign up form and click sign up button")
    public SignUpPage fillSignUpForm(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserFirstName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return new SignUpPage();
    }

    @Step ("Fill login form and click login button")
    public MainPage fillLoginForm(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new MainPage();
    }

    @Step ("Fill sign up form with exists user and click sign up button")
    public SignUpPage fillSignUpFormWithExistsUser(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return new SignUpPage();
    }

    @Step ("Fill login form with empty email field and click login button")
    public LoginPage fillLoginFormWithEmptyEmailField(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.clear();
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    @Step("Check validation message if login email field is empty")
    public void checkShowValidationMessageWhenLoginEmailIsEmpty(String message) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", LOGIN_EMAIL_ADDRESS_FIELD);
        assertEquals(message, actualMessage);
    }

    @Step ("Fill login form with empty password field and click login button")
    public LoginPage fillLoginFormWithEmptyPasswordField(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.clear();
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    @Step("Check validation message if password field is empty")
    public void checkShowValidationMessageWhenPasswordIsEmpty(String message) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", PASSWORD_FIELD);
        assertEquals(message, actualMessage);
    }

    @Step ("Fill login form with invalid email field and click login button")
    public LoginPage fillLoginFormWithInvalidEmail(LoginPageModel loginPageModel){
        LOGIN_EMAIL_ADDRESS_FIELD.setValue(loginPageModel.getUserEmailAddress());
        PASSWORD_FIELD.setValue(loginPageModel.getUserPassword());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    @Step("Check validation message if login email is invalid")
    public void checkShowValidationMessageWhenLoginEmailIsInvalid(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", LOGIN_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    @Step ("Fill sign up form with empty name field and click sign up button")
    public LoginPage fillSignUpFormWithEmptyNameField(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.clear();
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SIGNUP_BUTTON.click();

        return this;
    }

    @Step("Check validation message if sign up name is empty")
    public void checkShowValidationMessageWhenSignUpNameIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGN_UP_NAME_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    @Step ("Fill sign up form with empty email field and click sign up button")
    public LoginPage fillSignUpFormWithEmptyEmailField(RegistrationPageModel registrationPageModel) {
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.clear();
        SIGNUP_BUTTON.click();

        return this;
    }

    @Step("Check validation message if sign up email is empty")
    public void checkShowValidationMessageWhenSignUpEmailIsEmpty(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGNUP_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

    @Step ("Fill sign up form with invalid email field and click sign up button")
    public LoginPage fillSignUpFormWithInvalidEmail(RegistrationPageModel registrationPageModel){
        SIGN_UP_NAME_FIELD.setValue(registrationPageModel.getUserName());
        SIGNUP_EMAIL_ADDRESS_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        LOGIN_BUTTON.click();

        return new LoginPage();
    }

    @Step("Check validation message if sign up email is invalid")
    public void checkShowValidationMessageWhenSignUpEmailIsInvalid(String expectedInformationMessage) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SIGNUP_EMAIL_ADDRESS_FIELD);
        assertEquals(expectedInformationMessage, actualMessage);
    }

}
