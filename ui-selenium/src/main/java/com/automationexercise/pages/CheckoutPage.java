package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    private final By REGISTER_LOGIN_BUTTON = By.xpath("//p//a[@href=\"/login\"]");
    private final By PLACE_ORDER_BUTTON = By.xpath("//a[@class=\"btn btn-default check_out\"]");

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

    public PaymentPage clickPlaceOrderButton(){
        waitUntilClickable(PLACE_ORDER_BUTTON).click();
        return new PaymentPage(driver);
    }
}
