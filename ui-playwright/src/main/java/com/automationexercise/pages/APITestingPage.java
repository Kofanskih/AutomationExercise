package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class APITestingPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");

    public APITestingPage(Page page) {
        super(page);
    }

    @Step("Check correct title on the API Testing page")
    public void checkTitleOnTheAPITestingPage(String title){
        String actualText = CENTER_TEXT_TITLE.innerText();
        assertEquals(actualText, title);
    }
}
