package com.automationexercise.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ReadConfiguration extends Config {
    @Key("main.url")
    String mainUrl();

    @Key("browser.ch")
    String browserCh();

}
