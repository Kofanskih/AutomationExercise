package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.FooterPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Subscription")
@Feature("User subscription")
@Story("Subscription")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-007")
public class FooterTests {
    private String successfulSubscriptionValidationMessage = "You have been successfully subscribed!";
    private String errorValidationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"kofanskih08gmail.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "User subscribed")
    void userSubscribe(){
        new MainPage().acceptCookies();
        new FooterPage().checkUserIsSubscribed(new RegistrationPageModel().getSubscribeEmail(), successfulSubscriptionValidationMessage);
    }

    @Test(description = "Try to subscribe with invalid email")
    void userSubscribeWithInvalidEmail(){
        new MainPage().acceptCookies();
        new FooterPage().fillSubscribeFieldWithInvalidEmail(new RegistrationPageModel().getInvalidSubscribeEmail())
                .checkShowValidationMessageUsingInvalidEmailForSubscription(errorValidationMessage);
    }
}
