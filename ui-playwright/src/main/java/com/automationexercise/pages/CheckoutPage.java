package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    private final Locator REGISTER_LOGIN_BUTTON = page.locator("a[href='/login']").nth(1);

    public CheckoutPage(Page page) {
        super(page);
    }

    @Step("Check URL on the Checkout page")
    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Step("Go to The Login page")
    public LoginPage goToTheLoginPage(){
        REGISTER_LOGIN_BUTTON.click();
        return new LoginPage(page);
    }
}
