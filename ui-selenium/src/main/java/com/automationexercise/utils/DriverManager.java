package com.automationexercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverManager(){}

    @Step("Initialize WebDriver on demand (Lazy Initialization)")
    private static WebDriver initDriver() {
        String browser = ReadConfigs.getBrowserCh().toLowerCase().trim();
        boolean headless = ReadConfigs.isHeadless();

        WebDriver driver = switch (browser) {
            case "chrome" -> new ChromeDriver(headless ? new ChromeOptions().addArguments("--headless=new") : new ChromeOptions());
            case "firefox" -> new FirefoxDriver(headless ? new FirefoxOptions().addArguments("-headless") : new FirefoxOptions());
            case "edge" -> new EdgeDriver(headless ? new EdgeOptions().addArguments("--headless=new") : new EdgeOptions());
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigs.getTimeoutSeconds()));

        threadLocalDriver.set(driver);
        return driver;
    }

    @Step("Get current WebDriver instance")
    public static WebDriver getDriver(){
        if (threadLocalDriver.get() == null) {
            return initDriver();
        }
        return threadLocalDriver.get();
    }

    @Step("Quit WebDriver and clear thread context")
    public static void quitDriver(){
        if(threadLocalDriver != null){
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}
