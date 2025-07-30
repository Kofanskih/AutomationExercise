package utils;

import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

public class OwnerReadMainUrl {
    public static OwnerConfig config = ConfigFactory.create(OwnerConfig.class);

    @Step("API Read main URL from properties")
    public static String readMainUrl(){
        return config.mainUrl();
    }
}
