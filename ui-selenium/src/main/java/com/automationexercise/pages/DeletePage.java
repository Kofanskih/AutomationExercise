package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class DeletePage extends BasePage{
    private final By CONTINUE_BUTTON = By.cssSelector("[data-qa=\"continue-button\"]");
    private final By ACCOUNT_DELETED_TITLE = By.cssSelector("[data-qa=\"account-deleted\"]");

    public DeletePage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickContinueButtonOnTheDeletePage(){
        waitUntilClickable(CONTINUE_BUTTON).click();
        return new MainPage(driver);
    }

    public void checkTitleAfterDeletingAccount(String title){
        String actualText = waitUntilVisible(ACCOUNT_DELETED_TITLE).getText();
        assertEquals(actualText, title);
    }
}
