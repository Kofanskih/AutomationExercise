package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{
    private final By ACCEPT_COOKIES_BUTTON = By.className("fc-button-label");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement acceptCookiesButton() {
        return driver.findElement(ACCEPT_COOKIES_BUTTON);
    }

    public MainPage acceptCookies() {
        acceptCookiesButton().click();
        return this;
    }
}
