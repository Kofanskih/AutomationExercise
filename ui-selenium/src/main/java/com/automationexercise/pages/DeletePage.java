package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletePage extends BasePage{
    private final By CONTINUE_BUTTON = By.cssSelector("[data-qa=\"continue-button\"]");

    public DeletePage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickContinueButtonOnTheDeletePage(){
        waitUntilClickable(CONTINUE_BUTTON).click();
        return new MainPage(driver);
    }
}
