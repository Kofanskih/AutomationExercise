package com.automationexercise.ui.tests.videoTutorialsTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideoTutorialsTests extends BaseTest {
    private String expectedURL = "https://consent.youtube.com/m?continue=https%3A%2F%2Fwww.youtube.com%2Fc%2FAutomationExercise%3Fcbrd%3D1&gl=ES&m=0&pc=yt&cm=2&hl=ru&src=1";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void goToTheVideoTutorialsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickVideoTutorialsButton()
                .checkUrlOnThePage(expectedURL);
    }

}
