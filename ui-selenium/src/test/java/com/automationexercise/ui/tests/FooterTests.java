package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.FooterPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest{
    private String successfulSubscriptionValidationMessage = "You have been successfully subscribed!";

    @Test
    void userSubscribe(){
        new MainPage(driver)
                .acceptCookies();
        new FooterPage(driver)
                .checkUserIsSubscribed(new RegistrationPageModel().getSubscribeEmail(), successfulSubscriptionValidationMessage);
    }
}
