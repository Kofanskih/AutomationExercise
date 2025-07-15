package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends BasePage{
    private final SelenideElement TITLE = $("[class=\"active\"]");
    private final SelenideElement EMPTY_TITLE = $x("//b[contains(., 'Cart is empty!')]");
    private final SelenideElement HERE_BUTTON = $x("//u[contains(., 'here')]");
    private final SelenideElement DELETE_BUTTON = $x("//a[@class=\"cart_quantity_delete\"]");
    private final SelenideElement PROCEED_TO_CHECKOUT_BUTTON = $x("//div//a[@class=\"btn btn-default check_out\"]");

    public void checkUserOnTheCartPage(String title) {
        TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public void checkTheCartIsEmpty(String title) {
        EMPTY_TITLE.shouldBe(Condition.visible, Duration.ofSeconds(1))
                .shouldHave(Condition.exactTextCaseSensitive(title));
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