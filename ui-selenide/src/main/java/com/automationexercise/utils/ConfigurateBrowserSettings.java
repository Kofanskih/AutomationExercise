package com.automationexercise.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class ConfigurateBrowserSettings {
    public void setUp(){
        Configuration.browserSize = "1980x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        Configuration.headless = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }
}
