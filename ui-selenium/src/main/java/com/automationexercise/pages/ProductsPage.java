package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{
    private final By CENTER_TEXT_TITLE = By.cssSelector("[class=\"title text-center\"]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void checkTitleOnTheProductPage(String infoModalMessage) {
        String actualText = waitUntilVisible(CENTER_TEXT_TITLE).getText();
        assertEquals(actualText, infoModalMessage);
    }

}
