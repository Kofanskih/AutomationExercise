package com.automationexercise.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPage extends BasePage{
    private final SelenideElement REGISTER_LOGIN_BUTTON = $x("//p//a[@href=\"/login\"]");
    private final SelenideElement PLACE_ORDER_BUTTON = $x("//a[@class=\"btn btn-default check_out\"]");


    @Step("Check URL on the Checkout page")
    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    @Step("Go to The Login page")
    public LoginPage goToTheLoginPage(){
        REGISTER_LOGIN_BUTTON.click();
        return new LoginPage();
    }

    @Step("Click Place order button")
    public PaymentPage clickPlaceOrderButton(){
        PLACE_ORDER_BUTTON.click();
        return new PaymentPage();
    }
}
