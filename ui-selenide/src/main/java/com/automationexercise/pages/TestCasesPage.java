package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {
    private final SelenideElement CENTER_TEXT_TITLE = $("[class=\"title text-center\"]");

    public void checkTitleOnTheTestCasesPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }
}
