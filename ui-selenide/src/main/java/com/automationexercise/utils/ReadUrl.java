package com.automationexercise.utils;

import org.aeonbits.owner.ConfigFactory;

public class ReadUrl {

    public static String readMainUrl(){
        ReadConfiguration readConfiguration = ConfigFactory.create(ReadConfiguration.class,System.getProperties());
        return readConfiguration.mainUrl();
    }
}
