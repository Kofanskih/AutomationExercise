package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class VideoTutorialsPage extends BasePage{

    public VideoTutorialsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check URL on the Youtube")
    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }
}
