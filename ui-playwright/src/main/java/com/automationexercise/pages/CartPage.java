package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage{
    private final Locator TITLE = page.locator("li.active");

    public CartPage(Page page) {
        super(page);
    }

    @Step("Check that user is on the cart page")
    public void checkUserOnTheCartPage(String title) {
        String actualText = TITLE.innerText();
        assertEquals(actualText, title);
    }
}
