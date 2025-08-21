package com.automationexercise.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;

import static com.automationexercise.config.ConfigurationManager.config;

public class BrowserManager {
    public static Browser getBrowser(final Playwright playwright){
        return BrowserFactory.valueOf(config().browser().toUpperCase()).createInstance(playwright);
    }

    public static BrowserContext createContext(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(config().viewportWidth(), config().viewportHeight()));
    }
}
