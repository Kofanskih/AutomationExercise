package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    private final By ACCEPT_COOKIES_BUTTON = By.className("fc-button-label");
    private final By LOGGED_IN_TEXT = By.xpath("//a[contains(text(), 'Logged in as')]");

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

    public String isLoggedInText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGGED_IN_TEXT));
        return driver.findElement(LOGGED_IN_TEXT).getText();
    }

    public void checkUserLoggedIn(String expectedSubstring){
        String actualText = isLoggedInText().trim();
        assertTrue(actualText.contains(expectedSubstring),
                "The text was expected to contain: " + expectedSubstring + ", but was: " + actualText);
    }
}
