package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage{
    private final String LOGIN_EMAIL_ADDRESS_FIELD = "input[data-qa='login-email']";
    private final String PASSWORD_FIELD = "input[name='password']";
    private final String LOGIN_BUTTON = "button[data-qa='login-button']";
    private final Locator LOGIN_ERROR_TEXT = page.locator("text=Your email or password is incorrect!");

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

    @Step("Check login error message")
    public void checkLoginErrorMessage(String expected){
        String actualText = LOGIN_ERROR_TEXT.innerText();
        assertEquals(expected, actualText);
    }

    @Step ("Fill login form with empty email field and click login button")
    public LoginPage fillLoginFormWithEmptyEmailField(LoginPageModel loginPageModel){
        page.fill(PASSWORD_FIELD, loginPageModel.getUserPassword());
        page.click(LOGIN_BUTTON);
        return this;
    }
    public String getValidationMessage(Locator element) {
        return (String) element.evaluate("el => el.validationMessage");
    }

    @Step("Check validation message in login email field")
    public void checkShowValidationMessageLoginEmail(String expectedMessage) {
        Locator emailField = page.locator(LOGIN_EMAIL_ADDRESS_FIELD);
        String actualMessage = getValidationMessage(emailField);
        assertEquals(expectedMessage, actualMessage);
    }

    @Step ("Fill login form with empty password field and click login button")
    public LoginPage fillLoginFormWithEmptyPasswordField(LoginPageModel loginPageModel){
        page.fill(LOGIN_EMAIL_ADDRESS_FIELD, loginPageModel.getUserEmailAddress());
        page.click(LOGIN_BUTTON);
        return this;
    }

    @Step("Check validation message if password field is empty")
    public void checkShowValidationMessageWhenPasswordIsEmpty(String message) {
        Locator passwordField = page.locator(PASSWORD_FIELD);
        String actualMessage = getValidationMessage(passwordField);
        assertEquals(message, actualMessage);
    }
}
