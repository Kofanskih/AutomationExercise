package com.automationexercise.utils;

import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

public class ReadUrl {

    @Step("Read main URL from configuration")
    public static String readMainUrl(){
        ReadConfiguration readConfiguration = ConfigFactory.create(ReadConfiguration.class,System.getProperties());
        return readConfiguration.mainUrl();
    }
}
