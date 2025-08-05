package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage{
    private final By TITLE = By.cssSelector("[class=\"active\"]");
    private final By EMPTY_TITLE = By.xpath("//b[contains(., 'Cart is empty!')]");
    private final By HERE_BUTTON = By.xpath("//u[contains(., 'here')]");
    private final By DELETE_BUTTON = By.xpath("//a[@class=\"cart_quantity_delete\"]");

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

    public ProductsPage clickHereButtonTheCartPage(){
        waitUntilClickable(HERE_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CartPage deleteItemFromTheCart(){
        waitUntilClickable(DELETE_BUTTON).click();
        return this;
    }
}
