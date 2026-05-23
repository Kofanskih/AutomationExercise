package com.automationexercise.pages;

import com.automationexercise.utils.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    private final By REGISTER_LOGIN_BUTTON = By.xpath("//p//a[@href=\"/login\"]");
    private final By PLACE_ORDER_BUTTON = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public CheckoutPage() {
    }

    @Step("Check URL on the Checkout page")
    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Step("Go to The Login page")
    public LoginPage goToTheLoginPage(){
        waitUntilClickable(REGISTER_LOGIN_BUTTON).click();
        return new LoginPage();
    }

    @Step("Click Place order button")
    public PaymentPage clickPlaceOrderButton(){
        waitUntilClickable(PLACE_ORDER_BUTTON).click();
        return new PaymentPage();
    }
}
