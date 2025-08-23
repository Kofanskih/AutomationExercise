package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class TestCasesPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");

    public TestCasesPage(Page page) {
        super(page);
    }

    @Step("Check correct title on the Test cases page")
    public void checkTitleOnTheTestCasesPage(String title){
        String actualText = CENTER_TEXT_TITLE.innerText();
        assertEquals(actualText, title);
    }
}
