package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage{
    private final By TITLE = By.cssSelector("[class=\"active\"]");
    private final By EMPTY_TITLE = By.xpath("//b[contains(., 'Cart is empty!')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserOnTheCartPage(String title) {
        String actualText = waitUntilVisible(TITLE).getText();
        assertEquals(actualText, title);
    }

    public void checkTheCartIsEmpty(String title) {
        String actualText =waitUntilVisible(EMPTY_TITLE).getText();
        assertEquals(actualText, title);
    }
}
