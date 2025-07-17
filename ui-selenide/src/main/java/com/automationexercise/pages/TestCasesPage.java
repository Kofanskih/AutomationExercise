package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestCasesPage extends BasePage{
    private final SelenideElement CENTER_TEXT_TITLE = $("[class=\"title text-center\"]");
    private final SelenideElement LIST = $("[href=\"#collapse1\"]");
    private final SelenideElement EXPANDED_BLOCK = $x("//div[@id=\"collapse1\"]/ul[@class=\"list-group\"]");
    private final SelenideElement COLLAPSED_BLOCK = $x("//div[@id=\"collapse1\"][@class=\"panel-collapse collapsing\"]");

    @Step("Check correct title on the Test cases page")
    public void checkTitleOnTheTestCasesPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    @Step("Expand the collapsed list")
    public TestCasesPage expandCollapsedList(){
        LIST.click();
        return this;
    }

    @Step("Check the list is expanded")
    public void checkTheListIsExpanded(){
        EXPANDED_BLOCK.shouldBe(Condition.appear);
    }

    @Step("Collapse the expanded list")
    public TestCasesPage collapseExpandedList(){
        EXPANDED_BLOCK.shouldBe(Condition.appear);
        LIST.click();
        return this;
    }

    @Step("Check the list is collapsed")
    public void checkTheListIsCollapsed(){
        COLLAPSED_BLOCK.shouldBe(Condition.appear);
    }
}
