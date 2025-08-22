package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HeaderPage extends BasePage{
    private final Locator LOGIN_BUTTON = page.locator("text=Signup / Login");


    public HeaderPage(Page page) {
        super(page);
    }

    @Step("User click login button")
    public LoginPage clickLoginButton() {
        LOGIN_BUTTON.click();
        return new LoginPage(page);
    }
}
