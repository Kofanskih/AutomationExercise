package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest{
    private String successfulMessage = "Success! Your details have been submitted successfully.";

    @Test
    void sendContactMessage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .checkMessageWasSent(successfulMessage);
    }

    @Test
    void doNotSendContactMessage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickCancelButton()
                .checkHomeButtonNotAppear();
    }
}
