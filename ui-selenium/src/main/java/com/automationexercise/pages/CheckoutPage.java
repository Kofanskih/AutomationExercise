package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    private final By REGISTER_LOGIN_BUTTON = By.xpath("//p//a[@href=\"/login\"]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public LoginPage goToTheLoginPage(){
        waitUntilClickable(REGISTER_LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}
