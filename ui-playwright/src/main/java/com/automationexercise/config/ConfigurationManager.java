package com.automationexercise.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {
    public static ReadConfiguration config(){
        return ConfigCache.getOrCreate(ReadConfiguration.class);
    }
}
