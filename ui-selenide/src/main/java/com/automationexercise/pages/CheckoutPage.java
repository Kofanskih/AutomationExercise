package com.automationexercise.pages;

import com.codeborne.selenide.WebDriverRunner;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPage {

    public void checkUrlOnTheCheckoutPage(String expectedUrl) throws InterruptedException {
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }
}
