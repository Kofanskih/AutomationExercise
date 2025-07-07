package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement TEXT_TITLE = $("[class=\"active\"]");

    public void checkUserOnTheCartPage(String title){
        TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }
}
