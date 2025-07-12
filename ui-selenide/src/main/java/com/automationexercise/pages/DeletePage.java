package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DeletePage extends BasePage{
    private final SelenideElement ACCOUNT_DELETED_TITLE = $("[data-qa=\"account-deleted\"]");
    private final SelenideElement CONTINUE_BUTTON = $("[data-qa=\"continue-button\"]");

    public void checkTitleAfterDeletingAccount(String title){
        ACCOUNT_DELETED_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public MainPage clickContinueButtonOnTheDeletePage(){
        CONTINUE_BUTTON.click();
        return new MainPage();
    }
}
