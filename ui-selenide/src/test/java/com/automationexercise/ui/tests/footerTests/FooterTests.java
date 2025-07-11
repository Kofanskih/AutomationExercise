package com.automationexercise.ui.tests.footerTests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.FooterPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest {
    private String successfullSubscriptionValidationMessage = "You have been successfully subscribed!";
    private String errorValidationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"kofanskih08gmail.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void userSubscribe(){
        new MainPage().acceptCookies();
        new FooterPage().checkUserIsSubscribed(new RegistrationPageModel().getSubscribeEmail(), successfullSubscriptionValidationMessage);
    }

    @Test
    void userSubscribeWithInvalidEmail(){
        new MainPage().acceptCookies();
        new FooterPage().fillSubscribeFieldWithInvalidEmail(new RegistrationPageModel().getInvalidSubscribeEmail())
                .checkShowValidationMessageUsingInvalidEmailForSubscription(errorValidationMessage);
    }
}
