package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }
}
