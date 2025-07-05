package com.automationexercise.utils;

import com.codeborne.selenide.Configuration;

public class ConfigurateBrowserSettings {
    public void setUp(){
        Configuration.browserSize = "1980x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        Configuration.headless = true;
    }
}
