package com.automationexercise.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:url.properties"})
public interface ReadConfiguration extends Config {
    @Key("main.url")
    String mainUrl();
}
