package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest{
    private String successfulMessage = "Success! Your details have been submitted successfully.";
    private String expectedMainURL = "https://automationexercise.com/";
    private String invalidEmailValidationMessage = "1Адрес электронной почты должен содержать символ \"@\". В адресе \"brbrbbrbr.com\" отсутствует символ \"@\".";


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

    @Test
    void goToTheHomePageAfterSendingContactMessage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void fillContactUsformWithInvalidEmail(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageFormInvalidEmail())
                .checkShowValidationMessageInEmailField(invalidEmailValidationMessage);
    }
}
