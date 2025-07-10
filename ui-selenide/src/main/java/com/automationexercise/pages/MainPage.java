package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class MainPage {
    private final SelenideElement ACCEPT_COOKIES_BUTTON = $("[class=\"fc-button-label\"]");
    private final SelenideElement USER_LOGGED_IN_TEXT = $("[href=\"/logout\"]");
    private final SelenideElement LOGIN_ERROR_TEXT = $("[style=\"color: red;\"]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $("[class=\"modal-title w-100\"]");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $("[class=\"btn btn-success close-modal btn-block\"]");
    private final SelenideElement MODAL_WINDOW_HIDDEN = $("[class=\"modal fade\"]");
    private final SelenideElement VIEW_PRODUCT_BUTTON = $x("(//i[@class='fa fa-plus-square'])[3]");
    private final SelenideElement MEN_BUTTON = $("[href=\"#Men\"]");
    private final SelenideElement JEANS_MEN_BUTTON = $("[href=\"/category_products/6\"]");
    private final SelenideElement BRANDS_HM_BUTTON = $("[href=\"/brand_products/H&M\"]");
    private final SelenideElement VIEW_CART_BUTTON = $x("//p/a[@href=\"/view_cart\"]");

    public MainPage acceptCookies(){
        ACCEPT_COOKIES_BUTTON.click();
        return new MainPage();
    }

    public void checkUserLoggedIn(String loggedInText){
        USER_LOGGED_IN_TEXT.shouldHave(Condition.exactTextCaseSensitive(loggedInText));
    }

    public void checkLoginErrorMessage(String loginErrorMessage){
        LOGIN_ERROR_TEXT.shouldHave(Condition.exactTextCaseSensitive(loginErrorMessage));
    }

    public void checkUrlOnTheMainPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    public MainPage addItemToTheCartOnTheMainPage(){
        ADD_ITEM_TO_CART.scrollTo().click();
        return this;
    }

    public void checkAddedItemOnTheMainPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }

    public MainPage clickContinueShoppingButtonOnTheModalWindowOnTheMainPage(){
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    public void checkModalWindowIsClosedOnTheMainPage(){
        MODAL_WINDOW_HIDDEN.shouldBe(Condition.exist);
    }

    public MainPage clickViewProductOnTheMainPage(){
        VIEW_PRODUCT_BUTTON.scrollTo().click();
        return this;
    }

    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    public ProductsPage clickOnTheMenJeansCategoryOnTheMainPage(){
        MEN_BUTTON.click();
        JEANS_MEN_BUTTON.click();
        return new ProductsPage();
    }

    public ProductsPage clickOnTheBrandsNMCategoryOnTheMainPage(){
        BRANDS_HM_BUTTON.scrollTo().click();
        return new ProductsPage();
    }

    public CartPage clickOnTheViewCartButtonOnTheModalWindow(){
        VIEW_CART_BUTTON.click();
        return new CartPage();
    }

}
