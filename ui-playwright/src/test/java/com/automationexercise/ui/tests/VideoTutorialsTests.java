package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Video Tutorials")
@Feature("Video Tutorials")
@Story("Video Tutorials")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-011")
public class VideoTutorialsTests extends BaseTest{
    private String expectedURL = "https://consent.youtube.com/m?continue=https%3A%2F%2Fwww.youtube.com%2Fc%2FAutomationExercise";

    @Test(description = "Go to the Video Tutorials page")
    void goToTheVideoTutorialsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickVideoTutorialsButton()
                .checkUrlOnThePage(expectedURL);
    }
}
