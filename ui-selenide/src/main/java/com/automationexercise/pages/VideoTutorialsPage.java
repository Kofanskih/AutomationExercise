package com.automationexercise.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;

public class VideoTutorialsPage extends BasePage{

    @Step("Check URL on the Youtube")
    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }
}
