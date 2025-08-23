package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");

    public ProductsPage(Page page) {
        super(page);
    }

    @Step("Check title on the product page")
    public void checkTitleOnTheProductPage(String title) {
        String actualText = CENTER_TEXT_TITLE.innerText();
        assertEquals(actualText, title);
    }
}
