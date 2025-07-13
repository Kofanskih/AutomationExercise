package com.automationexercise.pages;

import com.codeborne.selenide.WebDriverRunner;

import static org.testng.AssertJUnit.assertEquals;

public class VideoTutorialsPage extends BasePage{

    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }
}
