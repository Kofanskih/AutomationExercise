package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class APITestingTests extends BaseTest{
    private String APITestingTitle = "APIS LIST FOR PRACTICE";

    @Test
    void goToTheAPITestingPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickAPITestingButton()
                .checkTitleOnTheAPITestingPage(APITestingTitle);
    }
}
