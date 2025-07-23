package utils;

import org.aeonbits.owner.ConfigFactory;

public class OwnerReadMainUrl {
    public static OwnerConfig config = ConfigFactory.create(OwnerConfig.class);

    public static String readMainUrl(){
        return config.mainUrl();
    }
}
