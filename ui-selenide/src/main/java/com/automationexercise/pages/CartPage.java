package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement TEXT_TITLE = $("[class=\"active\"]");
    private final SelenideElement EMPTY_TITLE = $("[id=\"empty_cart\"]");
    private final SelenideElement HERE_BUTTON = $x("//u[contains(., 'here')]");
    private final SelenideElement DELETE_BUTTON = $("[class=\"cart_quantity_delete\"]");
    private final SelenideElement PROCEED_TO_CHECKOUT_BUTTON = $x("//div//a[@class=\"btn btn-default check_out\"]");

    public void checkUserOnTheCartPage(String title) {
        TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public void checkTheCartIsEmpty(String title) {
        EMPTY_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public ProductsPage clickHereButtonTheCartPage(){
        HERE_BUTTON.click();
        return new ProductsPage();
    }

    public CartPage deleteItemFromTheCart(){
        DELETE_BUTTON.click();
        return this;
    }

    public CheckoutPage clickToCheckoutButtonOnTheCartPage(){
        PROCEED_TO_CHECKOUT_BUTTON.click();
        return new CheckoutPage();
    }


}