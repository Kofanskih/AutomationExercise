package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Feedback")
@Feature("Contact us")
@Story("Feedback")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-008")
public class ContactUsTests {
    private String successfulMessage = "Success! Your details have been submitted successfully.";
    private String expectedMainURL = "https://automationexercise.com/";
    private String invalidEmailValidationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"brbrbbrbr.com\" отсутствует символ \"@\".";
    private String emptyEmailValidationMessage = "Заполните это поле.";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "Send contact message on the Contact us page")
    void sendContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .checkMessageWasSent(successfulMessage);
    }

    @Test(description = "Cancel send contact message on the Contact us page")
    void doNotSendContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickCancelButton()
                .checkHomeButtonNotAppear();
    }

    @Test(description = "Go to the Home page after sending contact message")
    void goToTheHomePageAfterSendingContactMessage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageForm())
                .clickOKButton()
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Fill contact form with invalid email")
    void fillContactUsFormWithInvalidEmail(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageFormInvalidEmail())
                .checkShowValidationMessageInEmailField(invalidEmailValidationMessage);
    }

    @Test(description = "Fill contact form with empty email field")
    void fillContactUsFormWithEmptyEmailField(){
        new MainPage().acceptCookies();
        new HeaderPage().clickContactUsButton()
                .fillMessageForm(new ContactUsPageModel().messageFormEmptyEmail())
                .checkShowValidationMessageInEmailField(emptyEmailValidationMessage);
    }
}
