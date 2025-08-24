package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.*;

public class ProductsPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");
    private final Locator SEARCH_FIELD = page.locator("#search_product");
    private final Locator SEARCH_BUTTON = page.locator("#submit_search");
    private final Locator SEARCH_RESULT = page.getByText("Winter Top").first();
    private final Locator ADD_ITEM_TO_CART = page.locator("a[data-product-id='3']").first();
    private final Locator ADDED_MODAL_WINDOW_TEXT = page.locator("text=Your product has been added to cart.");
    private final Locator CONTINUE_SHOPPING_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue Shopping"));//("[class=\"btn btn-success close-modal btn-block\"]");
    private final Locator MODAL_WINDOW_HIDDEN = page.locator("div.modal.show");
    private final Locator VIEW_PRODUCT_BUTTON = page.locator("i.fa.fa-plus-square").nth(1);

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

    @Step("Add item to the cart")
    public ProductsPage addItemToTheCartOnTheProductsPage() {
        ADD_ITEM_TO_CART.click();
        return this;
    }

    @Step("Check added item on the Main page")
    public void checkAddedItemOnTheProductsPage(String infoModalMessage) {
        String actualText = ADDED_MODAL_WINDOW_TEXT.innerText();
        assertEquals(actualText, infoModalMessage);
    }

    @Step("Click continue shopping button on the modal window on the Main page")
    public ProductsPage clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage(){
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    @Step("Check that the modal window is closed on the Main page")
    public void checkModalWindowIsClosedOnTheProductsPage(){
        assertTrue(MODAL_WINDOW_HIDDEN.isDisabled(), "Modal window should be closed but is still visible");
    }

    @Step("Click view product button on the Main page")
    public ProductsPage clickViewProductOnTheMainPage(){
        VIEW_PRODUCT_BUTTON.click();
        return this;
    }

    @Step("Check URL on the Product page")
    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
