package com.automationexercise.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPage {
    private final SelenideElement REGISTER_LOGIN_BUTTON = $x("//p//a[@href=\"/login\"]");

    public void checkUrlOnTheCheckoutPage(String expectedUrl) throws InterruptedException {
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    public LoginPage goToTheLoginPage(){
        REGISTER_LOGIN_BUTTON.click();
        return new LoginPage();
    }
}
