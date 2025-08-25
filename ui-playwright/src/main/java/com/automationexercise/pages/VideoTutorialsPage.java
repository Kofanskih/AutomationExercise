package com.automationexercise.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;

public class VideoTutorialsPage extends BasePage{

    public VideoTutorialsPage(Page page) {
        super(page);
    }

    @Step("Check URL on the Youtube")
    public void checkUrlOnThePage(String expectedUrl){
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
