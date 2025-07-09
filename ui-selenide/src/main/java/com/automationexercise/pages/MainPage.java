package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class MainPage {
    private final SelenideElement ACCEPT_COOKIES_BUTTON = $("[class=\"fc-button-label\"]");
    private final SelenideElement USER_LOGGED_IN_TEXT = $("[href=\"/logout\"]");
    private final SelenideElement LOGIN_ERROR_TEXT = $("[style=\"color: red;\"]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $("[class=\"modal-title w-100\"]");

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

}
