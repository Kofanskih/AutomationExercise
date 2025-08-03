package com.automationexercise.pages;

import com.automationexercise.pageModels.LoginPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage{
    private final By LOGIN_EMAIL_ADDRESS_FIELD = By.cssSelector("[data-qa=\"login-email\"]");
    private final By PASSWORD_FIELD = By.cssSelector("[data-qa=\"login-password\"]");
    private final By LOGIN_BUTTON = By.cssSelector("[data-qa=\"login-button\"]");

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

    public MainPage fillLoginFormWithExistsUser(LoginPageModel loginPageModel){
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
}
