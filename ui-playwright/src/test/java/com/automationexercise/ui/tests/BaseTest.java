package com.automationexercise.ui.tests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.BrowserManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected BasePage basePage;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = BrowserManager.getBrowser(playwright);
        context = BrowserManager.createContext(browser);
        page = context.newPage();
        new MainPage(page).open();
    }

    @AfterMethod
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
