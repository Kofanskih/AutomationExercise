package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class DeletePage extends BasePage{
    private final By CONTINUE_BUTTON = By.cssSelector("[data-qa=\"continue-button\"]");
    private final By ACCOUNT_DELETED_TITLE = By.cssSelector("[data-qa=\"account-deleted\"]");

    public DeletePage() {}

    @Step("Click Continue button on the Delete page")
    public MainPage clickContinueButtonOnTheDeletePage(){
        waitUntilClickable(CONTINUE_BUTTON).click();
        return new MainPage();
    }

    @Step("Check the title after deleting account")
    public void checkTitleAfterDeletingAccount(String title){
        String actualText = waitUntilVisible(ACCOUNT_DELETED_TITLE).getText();
        assertEquals(actualText, title);
    }
}
