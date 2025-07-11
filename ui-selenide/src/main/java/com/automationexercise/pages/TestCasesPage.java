package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {
    private final SelenideElement CENTER_TEXT_TITLE = $("[class=\"title text-center\"]");
    private final SelenideElement LIST = $("[href=\"#collapse1\"]");
    private final SelenideElement EXPANDED_BLOCK = $("[class=\"panel-collapse in\"]");
    private final SelenideElement COLLAPSED_BLOCK = $("[class=\"collapsed\"]");

    public void checkTitleOnTheTestCasesPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public TestCasesPage expandCollapsedList(){
        LIST.click();
        return this;
    }

    public void checkTheListIsExpanded(){
        EXPANDED_BLOCK.shouldBe(Condition.appear);
    }

    public TestCasesPage collapseExpandedList(){
        EXPANDED_BLOCK.shouldBe(Condition.appear);
        LIST.click();
        return this;
    }

    public void checkTheListIsCollapsed(){
        COLLAPSED_BLOCK.shouldBe(Condition.appear);
    }
}
