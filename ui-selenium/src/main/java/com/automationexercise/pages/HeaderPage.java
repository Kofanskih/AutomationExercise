package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{
    private final By LOGIN_LOGOUT_BUTTON = By.cssSelector(".fa.fa-lock");
    private final By LOGO = By.xpath("//div[@class=\"logo pull-left\"]");
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickLogo(){
        waitUntilClickable(LOGO).click();
        return new MainPage(driver);
    }

    public LoginPage clickLoginLogoutButton(){
        waitUntilClickable(LOGIN_LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }
}
