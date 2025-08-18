package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    private final By REGISTER_LOGIN_BUTTON = By.xpath("//p//a[@href=\"/login\"]");
    private final By PLACE_ORDER_BUTTON = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check URL on the Checkout page")
    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Step("Go to The Login page")
    public LoginPage goToTheLoginPage(){
        waitUntilClickable(REGISTER_LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Click Place order button")
    public PaymentPage clickPlaceOrderButton(){
        waitUntilClickable(PLACE_ORDER_BUTTON).click();
        return new PaymentPage(driver);
    }
}
