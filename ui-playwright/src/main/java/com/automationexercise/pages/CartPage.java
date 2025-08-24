package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CartPage extends BasePage{
    private final Locator TITLE = page.locator("li.active");
    private final Locator EMPTY_TITLE = page.locator("#empty_cart");
    private final Locator HERE_BUTTON = page.locator("text=here");
    private final Locator DELETE_BUTTON = page.locator("a.cart_quantity_delete");
    private final Locator PROCEED_TO_CHECKOUT_BUTTON = page.locator("text=Proceed To Checkout");

    public CartPage(Page page) {
        super(page);
    }

    @Step("Check that user is on the cart page")
    public void checkUserOnTheCartPage(String title) {
        String actualText = TITLE.innerText();
        assertEquals(actualText, title);
    }

    @Step("Check that cart is empty")
    public void checkTheCartIsEmpty(String title) {
        String actualText = EMPTY_TITLE.innerText();
        assertTrue("Expected text to contain: '" + title + "' but was: '" + actualText + "'",
                actualText.contains(title));
    }

    @Step("Click here button on the empty cart page")
    public ProductsPage clickHereButtonTheCartPage(){
        HERE_BUTTON.click();
        return new ProductsPage(page);
    }

    @Step("Delete item on the cart page")
    public CartPage deleteItemFromTheCart(){
        DELETE_BUTTON.click();
        return this;
    }

    @Step("Click checkout button on the cart page")
    public CheckoutPage clickToCheckoutButtonOnTheCartPage(){
        PROCEED_TO_CHECKOUT_BUTTON.click();
        return new CheckoutPage(page);
    }
}
