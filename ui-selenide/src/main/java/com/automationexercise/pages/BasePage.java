package com.automationexercise.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.automationexercise.utils.ReadUrl.readMainUrl;

public class BasePage {

    @Step("Open main url")
    public BasePage open(){
        Selenide.open(readMainUrl());
        return new BasePage();
    }

    @Step("Close Webdriver")
    public void close(){
        Selenide.closeWebDriver();
    }
}
