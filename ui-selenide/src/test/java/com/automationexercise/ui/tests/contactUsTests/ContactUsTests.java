package com.automationexercise.ui.tests.contactUsTests;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest {
    private String successfulMessage = "Success! Your details have been submitted successfully.";
    private String expectedMainURL = "https://automationexercise.com/";
    private String invalidEmailValidationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"brbrbbrbr.com\" отсутствует символ \"@\".";
    private String emptyEmailValidationMessage = "Заполните это поле.";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void sendContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .checkMessageWasSent(successfulMessage);
    }

    @Test
    void doNotSendContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickCancelButton()
                .checkHomeButtonNotAppear();
    }

    @Test
    void goToTheHomePageAfterSendingContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void fillContactUsformWithInvalidEmail(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageFormInvalidEmail())
                .checkShowValidationMessageInEmailField(invalidEmailValidationMessage);
    }

    @Test
    void fillContactUsformWithEmptyEmailField(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageFormEmptyEmail())
                .checkShowValidationMessageInEmailField(emptyEmailValidationMessage);
    }
}
