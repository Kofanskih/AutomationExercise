package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.FooterPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest{
    private String successfulSubscriptionValidationMessage = "You have been successfully subscribed!";
    private String errorValidationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"test.com\" отсутствует символ \"@\".";

    @Test
    void userSubscribe(){
        new MainPage(driver)
                .acceptCookies();
        new FooterPage(driver)
                .checkUserIsSubscribed(new RegistrationPageModel().getSubscribeEmail(), successfulSubscriptionValidationMessage);
    }

    @Test
    void userSubscribeWithInvalidEmail(){
        new MainPage(driver)
                .acceptCookies();
        new FooterPage(driver)
                .fillSubscribeFieldWithInvalidEmail(new RegistrationPageModel().getInvalidSubscribeEmail())
                .checkShowValidationMessageUsingInvalidEmailForSubscription(errorValidationMessage);
    }
}
