package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{
    private final By CENTER_TEXT_TITLE = By.cssSelector("[class=\"title text-center\"]");
    private final By SEARCH_FIELD = By.id("search_product");
    private final By SEARCH_BUTTON = By.id("submit_search");
    private final By SEARCH_RESULT = By.xpath("//p[contains(., 'Winter Top')]");
    private final By ADD_ITEM_TO_CART = By.cssSelector("[data-product-id=\"3\"]");
    private final By ADDED_MODAL_WINDOW_TEXT = By.xpath("//div[@class='modal-body']//p[@class='text-center']");

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

    public ProductsPage addItemToTheCartOnTheProductsPage(){
        WebElement element = driver.findElement(ADD_ITEM_TO_CART);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(ADD_ITEM_TO_CART).click();
        return this;
    }

    private WebElement addedModalWindow() {
        return waitUntilVisible(ADDED_MODAL_WINDOW_TEXT);
    }

    public void checkAddedItemOnTheProductsPage(String infoModalMessage) {
        String actualText = addedModalWindow().getText();
        assertEquals(actualText, infoModalMessage);
    }

}
