package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DeletePage extends BasePage{
    private final SelenideElement ACCOUNT_DELETED_TITLE = $("[data-qa=\"account-deleted\"]");
    private final SelenideElement CONTINUE_BUTTON = $("[data-qa=\"continue-button\"]");

    @Step("Check the title after deleting account")
    public void checkTitleAfterDeletingAccount(String title){
        ACCOUNT_DELETED_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    @Step("Click Continue button on the Delete page")
    public MainPage clickContinueButtonOnTheDeletePage(){
        CONTINUE_BUTTON.click();
        return new MainPage();
    }
}
