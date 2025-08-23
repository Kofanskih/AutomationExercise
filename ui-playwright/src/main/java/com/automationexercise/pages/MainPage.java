package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPage extends BasePage{
    private final Locator ACCEPT_COOKIES_BUTTON = page.locator(".fc-button-label").filter(new Locator.FilterOptions().setHasText("Соглашаюсь"));
    private final Locator USER_LOGGED_IN_TEXT = page.locator("text=Logged in as");
    private final Locator ADD_ITEM_TO_CART = page.locator("a[data-product-id='3']").first();
    private final Locator ADDED_MODAL_WINDOW_TEXT = page.locator("text=Your product has been added to cart.");

    public MainPage(Page page) {
        super(page);
    }

    @Step("User accepts cookies")
    public MainPage acceptCookies(){
        ACCEPT_COOKIES_BUTTON.click();
        return this;
    }

    public void checkUserLoggedInText(String loggedInText) {
        String actualText = USER_LOGGED_IN_TEXT.innerText();
        assertTrue("Expected text to contain: '" + loggedInText + "' but was: '" + actualText + "'",
                actualText.contains(loggedInText));
    }

    @Step("Check URL on the Main page")
    public void checkUrlOnTheMainPage(String expectedUrl){
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Step("Add item to the cart")
    public MainPage addItemToTheCartOnTheMainPage() {
        ADD_ITEM_TO_CART.click();
        return this;
    }

    @Step("Check added item on the Main page")
    public void checkProductAddedMessage(String infoModalMessage) {
        String actualText = ADDED_MODAL_WINDOW_TEXT.innerText();
        assertEquals(actualText, infoModalMessage);
    }
}
