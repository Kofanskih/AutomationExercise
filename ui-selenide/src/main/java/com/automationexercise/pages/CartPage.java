package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement TEXT_TITLE = $("[class=\"active\"]");
    private final SelenideElement EMPTY_TITLE = $("[id=\"empty_cart\"]");
    private final SelenideElement HERE_BUTTON = $x("//u[contains(., 'here')]");

    public void checkUserOnTheCartPage(String title) {
        TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public void checkTheCartIsEmpty(String title) {
        EMPTY_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public CartPage clickHereButtonTheCartPage(){
        HERE_BUTTON.click();
        return this;
    }

}