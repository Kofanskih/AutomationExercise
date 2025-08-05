package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{
    private final By CENTER_TEXT_TITLE = By.cssSelector("[class=\"title text-center\"]");
    private final By SEARCH_FIELD = By.id("search_product");
    private final By SEARCH_BUTTON = By.id("submit_search");
    private final By SEARCH_RESULT = By.xpath("//p[contains(., 'Winter Top')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void checkTitleOnTheProductPage(String infoModalMessage) {
        String actualText = waitUntilVisible(CENTER_TEXT_TITLE).getText();
        assertEquals(actualText, infoModalMessage);
    }

    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        waitUntilClickable(SEARCH_FIELD).sendKeys(searchedItem);
        waitUntilClickable(SEARCH_BUTTON).click();
        return this;
    }

    public void checkSearchedItemOnTheProductsPage(String searchedItem){
        String actualText = waitUntilVisible(SEARCH_RESULT).getText();
        assertEquals(actualText, searchedItem);
    }

}
