package com.automationexercise.pages;

import io.qameta.allure.Step;
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
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("[class=\"btn btn-success close-modal btn-block\"]");
    private final By MODAL_WINDOW_HIDDEN = By.cssSelector("[class=\"modal fade\"]");
    private final By VIEW_PRODUCT_BUTTON = By.xpath("(//i[@class='fa fa-plus-square'])[2]");
    private final By KIDS_BUTTON = By.cssSelector("[href=\"#Kids\"]");
    private final By TOP_SHIRTS_KIDS_BUTTON = By.cssSelector("[href=\"/category_products/5\"]");
    private final By BRANDS_MADAME_BUTTON = By.cssSelector("[href=\"/brand_products/Madame\"]");
    private final By VIEW_CART_BUTTON = By.xpath("(//p[@class=\"text-center\"])[2]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check title on the product page")
    public void checkTitleOnTheProductPage(String infoModalMessage) {
        String actualText = waitUntilVisible(CENTER_TEXT_TITLE).getText();
        assertEquals(actualText, infoModalMessage);
    }

    @Step("Search item on the Products page")
    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        waitUntilClickable(SEARCH_FIELD).sendKeys(searchedItem);
        waitUntilClickable(SEARCH_BUTTON).click();
        return this;
    }

    @Step("Check searched item on the Products page")
    public void checkSearchedItemOnTheProductsPage(String searchedItem){
        String actualText = waitUntilVisible(SEARCH_RESULT).getText();
        assertEquals(actualText, searchedItem);
    }

    @Step("Add item to the cart on the Products page")
    public ProductsPage addItemToTheCartOnTheProductsPage(){
        WebElement element = driver.findElement(ADD_ITEM_TO_CART);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(ADD_ITEM_TO_CART).click();
        return this;
    }

    private WebElement addedModalWindow() {
        return waitUntilVisible(ADDED_MODAL_WINDOW_TEXT);
    }

    @Step("Check added item on the Modal window")
    public void checkAddedItemOnTheProductsPage(String infoModalMessage) {
        String actualText = addedModalWindow().getText();
        assertEquals(actualText, infoModalMessage);
    }

    @Step("Click continue shopping button on the Modal window")
    public ProductsPage clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage(){
        waitUntilVisible(CONTINUE_SHOPPING_BUTTON).click();
        return this;
    }

    public WebElement modalWindowIsHiddenElement(){
        return driver.findElement(MODAL_WINDOW_HIDDEN);
    }

    @Step("Check that modal window is closed")
    public void checkModalWindowIsClosedOnTheProductsPage(){
        modalWindowIsHiddenElement().isDisplayed();
    }

    @Step("Click view product button on the Products page")
    public ProductsPage clickViewProductOnTheProductsPage(){
        WebElement element = driver.findElement(VIEW_PRODUCT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(VIEW_PRODUCT_BUTTON).click();
        return this;
    }

    @Step("Check URL on the Products page")
    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    @Step("Click on the Kids Tops category on the Products page")
    public ProductsPage clickOnTheKidsTopsCategoryOnTheProductsPage(){
        waitUntilClickable(KIDS_BUTTON).click();
        waitUntilVisible(TOP_SHIRTS_KIDS_BUTTON).click();
        return this;
    }

    @Step("Click on the Brands Madame category on the Products page")
    public ProductsPage clickOnTheBrandsMadameCategoryOnTheProductsPage(){
        WebElement element = driver.findElement(BRANDS_MADAME_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(BRANDS_MADAME_BUTTON).click();
        return this;
    }

    @Step("Click on the view cart button on the Modal window")
    public CartPage clickOnTheViewCartButtonOnTheModalWindow() {
        waitUntilVisible(VIEW_CART_BUTTON).click();
        return new CartPage(driver);
    }
}
