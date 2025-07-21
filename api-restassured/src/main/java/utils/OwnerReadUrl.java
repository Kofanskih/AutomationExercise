package utils;

import org.aeonbits.owner.ConfigFactory;

public class OwnerReadUrl {
    public static String readMainUrl(){
        OwnerConfig config = ConfigFactory.create(OwnerConfig.class);
        return config.mainUrl();
    }
}
