package com.automationexercise.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.automationexercise.config.ConfigurationManager.config;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    @Step("Set browser configuration")
    public void configurePage(final Page page){
        this.page = page;
        page.setDefaultTimeout(config().timeout());
    }

    @Step("Navigate to the main page")
    public MainPage open() {
        page.navigate(config().mainUrl());
        return new MainPage(page);
    }
}
