package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BasePage{
    private final By LOGIN_LOGOUT_BUTTON = By.cssSelector(".fa.fa-lock");;
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement loginLogoutButton() {
        return driver.findElement(LOGIN_LOGOUT_BUTTON);
    }

    public LoginPage clickLoginLogoutButton(){
        loginLogoutButton().click();
        return new LoginPage(driver);
    }
}
