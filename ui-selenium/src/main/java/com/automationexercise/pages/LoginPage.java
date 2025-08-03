package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage{
    private final By LOGIN_EMAIL_ADDRESS_FIELD = By.cssSelector("[data-qa=\"login-email\"]");
    private final By PASSWORD_FIELD = By.cssSelector("[data-qa=\"login-password\"]");
    private final By LOGIN_BUTTON = By.cssSelector("[data-qa=\"login-button\"]");
    private final By LOGIN_ERROR_TEXT = By.cssSelector("[style='color: red;']");
    private final By SIGN_UP_NAME_FIELD = By.cssSelector("[data-qa=\"signup-name\"]");
    private final By SIGNUP_EMAIL_ADDRESS_FIELD = By.cssSelector("[data-qa=\"signup-email\"]");
    private final By SIGNUP_BUTTON = By.cssSelector("[data-qa=\"signup-button\"]");
    private final By SIGNUP_ERROR_MESSAGE = By.cssSelector("[style=\"color: red;\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement emailInput() {
        return driver.findElement(LOGIN_EMAIL_ADDRESS_FIELD);
    }

    private WebElement passwordInput() {
        return driver.findElement(PASSWORD_FIELD);
    }

    private WebElement loginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

    private WebElement signUpNameInput() {
        return driver.findElement(SIGN_UP_NAME_FIELD);
    }

    private WebElement signUpEmailInput() {
        return driver.findElement(SIGNUP_EMAIL_ADDRESS_FIELD);
    }

    private WebElement signUpButton() {
        return driver.findElement(SIGNUP_BUTTON);
    }

    public String getLoginErrorText() {
        return driver.findElement(LOGIN_ERROR_TEXT).getText();
    }
    public String getSignUpErrorText() {
        return driver.findElement(SIGNUP_ERROR_MESSAGE).getText();
    }

    public MainPage fillLoginForm(LoginPageModel loginPageModel){
        emailInput().sendKeys(loginPageModel.getUserEmailAddress());
        passwordInput().sendKeys(loginPageModel.getUserPassword());
        loginButton().click();

        return new MainPage(driver);
    }

    public LoginPage fillLoginFormWithEmptyEmailField(LoginPageModel loginPageModel){
        emailInput().clear();
        passwordInput().sendKeys(loginPageModel.getUserPassword());
        loginButton().click();

        return this;
    }

    public void checkShowValidationMessageWhenLoginEmailIsEmpty(String expectedMessage) {
        WebElement emailField = emailInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", emailField);
        assertEquals(expectedMessage, actualMessage);
    }

    public LoginPage fillLoginFormWithEmptyPasswordField(LoginPageModel loginPageModel){
        emailInput().sendKeys(loginPageModel.getUserEmailAddress());
        passwordInput().clear();
        loginButton().click();

        return this;
    }

    public void checkShowValidationMessageWhenLoginPasswordIsEmpty(String expectedMessage) {
        WebElement passwordField = passwordInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", passwordField);
        assertEquals(expectedMessage, actualMessage);
    }

    public void checkLoginErrorMessage(String expected){
        String actualText = getLoginErrorText();
        assertEquals(expected, actualText);
    }

    public void checkShowValidationMessageWhenEmailIsInvalid(String expectedMessage) {
        WebElement emailField = emailInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", emailField);
        assertEquals(expectedMessage, actualMessage);
    }

    public SignUpPage fillSignUpForm(RegistrationPageModel registrationPageModel) {
        signUpNameInput().sendKeys(registrationPageModel.getUserFirstName());
        signUpEmailInput().sendKeys(registrationPageModel.getUserEmailAddress());
        signUpButton().click();

        return new SignUpPage(driver);
    }

    public SignUpPage fillSignUpFormWithExistsUser(RegistrationPageModel registrationPageModel) {
        signUpNameInput().sendKeys(registrationPageModel.getUserName());
        signUpEmailInput().sendKeys(registrationPageModel.getUserEmailAddress());
        signUpButton().click();

        return new SignUpPage(driver);
    }

    public void checkSignUpErrorMessage(String expected){
        String actualText = getSignUpErrorText();
        assertEquals(expected, actualText);
    }

    public LoginPage fillSignUpFormWithEmptyNameField(RegistrationPageModel registrationPageModel){
        signUpNameInput().clear();
        signUpEmailInput().sendKeys(registrationPageModel.getUserEmailAddress());
        signUpButton().click();

        return this;
    }

    public void checkShowValidationMessageWhenSignUpNameIsEmpty(String expectedMessage) {
        WebElement signUpName = signUpNameInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", signUpName);
        assertEquals(expectedMessage, actualMessage);
    }

    public LoginPage fillSignUpFormWithEmptyEmailField(RegistrationPageModel registrationPageModel){
        signUpNameInput().sendKeys(registrationPageModel.getUserFirstName());
        signUpEmailInput().clear();
        signUpButton().click();

        return this;
    }

    public void checkShowValidationMessageWhenSignUpEmailIsEmpty(String expectedMessage) {
        WebElement signUpEmail = signUpEmailInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", signUpEmail);
        assertEquals(expectedMessage, actualMessage);
    }

    public LoginPage fillSignUpFormWithInvalidEmail(RegistrationPageModel registrationPageModel){
        signUpNameInput().sendKeys(registrationPageModel.getUserName());
        signUpEmailInput().sendKeys(registrationPageModel.getUserEmailAddress());
        signUpButton().click();

        return this;
    }

    public void checkShowValidationMessageWhenSignUpEmailIsInvalid(String expectedMessage) {
        WebElement signUpEmail = signUpEmailInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", signUpEmail);
        assertEquals(expectedMessage, actualMessage);
    }
}
