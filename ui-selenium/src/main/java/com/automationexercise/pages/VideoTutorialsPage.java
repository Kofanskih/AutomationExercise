package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class VideoTutorialsPage extends BasePage{

    public VideoTutorialsPage(WebDriver driver) {
        super(driver);
    }

    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }
}
