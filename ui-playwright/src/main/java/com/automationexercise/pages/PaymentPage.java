package com.automationexercise.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class PaymentPage extends BasePage{

    public PaymentPage(Page page) {
        super(page);
    }

    @Step("Check URL on the Payment page")
    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = page.url();
        assertEquals(actualUrl, expectedUrl);
    }
}
