package com.automationexercise.utils;

import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

public class ReadConfigs {
    private static final ReadConfiguration CONFIG =
            ConfigFactory.create(ReadConfiguration.class, System.getProperties());

    @Step("Read main URL from configuration")
    public static String getMainUrl() {
        return CONFIG.mainUrl();
    }

    public static String getBrowserCh() {
        return CONFIG.browserCh();
    }

}
