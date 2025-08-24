package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class DeletePage extends BasePage{
    private final Locator CONTINUE_BUTTON = page.locator("[data-qa='continue-button']");
    private final Locator ACCOUNT_DELETED_TITLE = page.locator("[data-qa='account-deleted']");

    public DeletePage(Page page) {
        super(page);
    }

    @Step("Click Continue button on the Delete page")
    public MainPage clickContinueButtonOnTheDeletePage(){
        CONTINUE_BUTTON.click();
        return new MainPage(page);
    }

    @Step("Check the title after deleting account")
    public void checkTitleAfterDeletingAccount(String title){
        String actualText = ACCOUNT_DELETED_TITLE.innerText();
        assertEquals(actualText, title);
    }
}
