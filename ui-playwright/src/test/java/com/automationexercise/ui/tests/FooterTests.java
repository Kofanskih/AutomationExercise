package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.SubscriptionPageModel;
import com.automationexercise.pages.FooterPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Subscription")
@Feature("User subscription")
@Story("Subscription")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-007")
public class FooterTests extends BaseTest{
    private String successfulSubscriptionValidationMessage = "You have been successfully subscribed!";

    @Test(description = "User subscribed")
    void userSubscribe(){
        new MainPage(page)
                .acceptCookies();
        new FooterPage(page)
                .checkUserIsSubscribed(new SubscriptionPageModel().getSubscribeEmail(), successfulSubscriptionValidationMessage);
    }
}
