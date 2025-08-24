package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");
    private final Locator SEARCH_FIELD = page.locator("#search_product");
    private final Locator SEARCH_BUTTON = page.locator("#submit_search");
    private final Locator SEARCH_RESULT = page.getByText("Winter Top").first();

    public ProductsPage(Page page) {
        super(page);
    }

    @Step("Check title on the product page")
    public void checkTitleOnTheProductPage(String title) {
        String actualText = CENTER_TEXT_TITLE.innerText();
        assertEquals(actualText, title);
    }

    @Step("Search item on the Products page")
    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        SEARCH_FIELD.fill(searchedItem);
        SEARCH_BUTTON.click();
        return this;
    }

    @Step("Check searched item on the Products page")
    public void checkSearchedItemOnTheProductsPage(String searchedItem){
        String actualText = SEARCH_RESULT.innerText();
        assertEquals(actualText, searchedItem);
    }
}
