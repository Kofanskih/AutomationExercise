package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    private final By ACCEPT_COOKIES_BUTTON = By.className("fc-button-label");
    private final By LOGGED_IN_TEXT = By.xpath("//a[contains(text(), 'Logged in as')]");
    private final By ADD_ITEM_TO_CART = By.cssSelector("[data-product-id=\"3\"]");
    private final By ADDED_MODAL_WINDOW_TEXT = By.xpath("//div[@class='modal-body']//p[@class='text-center']");
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("[class=\"btn btn-success close-modal btn-block\"]");
    private final By MODAL_WINDOW_HIDDEN = By.cssSelector("[class=\"modal fade\"]");
    private final By VIEW_PRODUCT_BUTTON = By.xpath("(//i[@class='fa fa-plus-square'])[3]");
    private final By MEN_BUTTON = By.cssSelector("[href=\"#Men\"]");
    private final By JEANS_MEN_BUTTON = By.cssSelector("[href=\"/category_products/6\"]");
    private final By BRANDS_HM_BUTTON = By.cssSelector("[href=\"/brand_products/H&M\"]");
    private final By VIEW_CART_BUTTON = By.xpath("//p/a[@href=\"/view_cart\"]");
    private final By TEST_CASES_CAROUSEL_BUTTON = By.xpath("//div[@class=\"carousel-inner\"]//a[@href=\"/test_cases\"]");
    private final By API_TESTING_CAROUSEL_BUTTON = By.xpath("//div[@class=\"carousel-inner\"]//a[@href=\"/api_list\"]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage acceptCookies() {
        waitUntilClickable(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

    public String isLoggedInText() {
        return waitUntilVisible(LOGGED_IN_TEXT).getText();
    }

    public void checkUserLoggedInText(String expectedSubstring){
        String actualText = isLoggedInText();
        assertTrue(actualText.contains(expectedSubstring));
    }

    public void checkUrlOnTheMainPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    public MainPage addItemToTheCartOnTheMainPage() {
        waitUntilClickable(ADD_ITEM_TO_CART).click();
        return this;
    }

    private WebElement addedModalWindow() {
        return waitUntilVisible(ADDED_MODAL_WINDOW_TEXT);
    }

    public void checkProductAddedMessage(String infoModalMessage) {
        String actualText = addedModalWindow().getText();
        assertEquals(actualText, infoModalMessage);
    }

    public MainPage clickContinueShoppingButtonOnTheModalWindowOnTheMainPage(){
        waitUntilClickable(CONTINUE_SHOPPING_BUTTON).click();
        return this;
    }

    public WebElement modalWindowIsHiddenElement(){
        return driver.findElement(MODAL_WINDOW_HIDDEN);
    }

    public void checkModalWindowIsClosedOnTheMainPage(){
        modalWindowIsHiddenElement().isDisplayed();
    }

    public MainPage clickViewProductOnTheMainPage(){
        WebElement element = driver.findElement(VIEW_PRODUCT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(VIEW_PRODUCT_BUTTON).click();
        return this;
    }

    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    public ProductsPage clickOnTheMenJeansCategoryOnTheMainPage(){
        waitUntilClickable(MEN_BUTTON).click();
        waitUntilVisible(JEANS_MEN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public ProductsPage clickOnTheBrandsNMCategoryOnTheMainPage(){
        WebElement element = driver.findElement(BRANDS_HM_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilClickable(BRANDS_HM_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CartPage clickOnTheViewCartButtonOnTheModalWindow(){
        waitUntilClickable(VIEW_CART_BUTTON).click();
        return new CartPage(driver);
    }

    public TestCasesPage clickOnTheTestCasesButtonOnTheCarousel(){
        waitUntilClickable(TEST_CASES_CAROUSEL_BUTTON).click();
        return new TestCasesPage(driver);
    }

    public APITestingPage clickOnTheAPITestingButtonOnTheCarousel(){
        waitUntilClickable(API_TESTING_CAROUSEL_BUTTON).click();
        return new APITestingPage(driver);
    }
}
