package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class DeletePage extends BasePage{
    private final Locator CONTINUE_BUTTON = page.locator("[data-qa='continue-button']");

    public DeletePage(Page page) {
        super(page);
    }

    @Step("Click Continue button on the Delete page")
    public MainPage clickContinueButtonOnTheDeletePage(){
        CONTINUE_BUTTON.click();
        return new MainPage(page);
    }
}
