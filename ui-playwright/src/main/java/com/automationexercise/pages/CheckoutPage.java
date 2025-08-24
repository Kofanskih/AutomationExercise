package com.automationexercise.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CheckoutPage extends BasePage{

    public CheckoutPage(Page page) {
        super(page);
    }

    @Step("Check URL on the Checkout page")
    public void checkUrlOnTheCheckoutPage(String expectedUrl) {
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
