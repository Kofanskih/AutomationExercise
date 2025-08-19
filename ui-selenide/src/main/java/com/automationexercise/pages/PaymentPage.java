package com.automationexercise.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;

public class PaymentPage extends BasePage{

    @Step("Check URL on the Payment page")
    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }
}
