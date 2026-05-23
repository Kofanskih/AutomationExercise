package com.automationexercise.pages;

import com.automationexercise.utils.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public BasePage() {}

    protected WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    protected WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @Step("Wait until the WebElement becomes clickable")
    protected WebElement waitUntilClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Wait until the WebElement becomes visible")
    protected WebElement waitUntilVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
