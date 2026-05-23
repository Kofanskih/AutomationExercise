package com.automationexercise.pages;

import com.automationexercise.utils.DriverManager;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class VideoTutorialsPage extends BasePage{

    public VideoTutorialsPage() {}

    @Step("Check URL on the Youtube")
    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }
}
