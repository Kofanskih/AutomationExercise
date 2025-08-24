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

    @Test(description = "Send contact message on the Contact us page")
    void sendContactMessage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickContactUsButton()
                .fillMessageFormAndAcceptAlert(new ContactUsPageModel().messageForm())
                .checkMessageWasSent(successfulMessage);
    }
}
