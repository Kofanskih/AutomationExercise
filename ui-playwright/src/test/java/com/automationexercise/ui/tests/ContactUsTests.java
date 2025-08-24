package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Feedback")
@Feature("Contact us")
@Story("Feedback")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-008")
public class ContactUsTests extends BaseTest{
    private String successfulMessage = "Success! Your details have been submitted successfully.";
    private String expectedMainURL = "https://automationexercise.com/";

    @Test(description = "Send contact message on the Contact us page")
    void sendContactMessage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickContactUsButton()
                .fillMessageFormAndAcceptAlert(new ContactUsPageModel().messageForm())
                .checkMessageWasSent(successfulMessage);
    }

    @Test(description = "Cancel send contact message on the Contact us page")
    void doNotSendContactMessage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickContactUsButton()
                .fillMessageFormAndCancelAlert(new ContactUsPageModel().messageForm())
                .checkHomeButtonNotAppear();
    }

    @Test(description = "Go to the Home page after sending contact message")
    void goToTheHomePageAfterSendingContactMessage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickContactUsButton()
                .fillMessageFormAndAcceptAlert(new ContactUsPageModel().messageForm())
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }
}