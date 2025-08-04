package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage{
    private final By TITLE = By.cssSelector("[class=\"active\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserOnTheCartPage(String title) {
        String actualText = waitUntilVisible(TITLE).getText();
        assertEquals(actualText, title);
    }
}
