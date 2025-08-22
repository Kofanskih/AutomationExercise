package com.automationexercise.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:config.properties", "classpath:allure.properties"})
public interface ReadConfiguration extends Config {
    @Key("main.url")
    String mainUrl();

    @Key("allure.results.directory")
    String allureResultsDir();


    @Key("base.test.video.path")
    String baseTestVideoPath();

    String browser();

    boolean headless();

    @Key("slow.motion")
    int slowMotion();

    int timeout();

    boolean video();

    @Key("viewport.width")
    int viewportWidth();

    @Key("viewport.height")
    int viewportHeight();
}
