package utils;

import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPath {
    private static final String PATH = "src/main/resources/paths.properties";

    @Step("API Read path from properties")
    private static Properties readPath() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream(PATH);
        props.load(input);
        return props;
    }

    @Step("API get path from properties")
    public static String getPath(String keyProperty) throws IOException {
        String key = readPath().getProperty(keyProperty);
        return key;
    }
}
