package com.automationexercise.pages;

import com.automationexercise.pageModels.SubscriptionPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;

public class FooterPage extends BasePage{
    private final Locator SUBSCRIBE_FIELD = page.locator("#susbscribe_email");
    private final Locator SUBSCRIBE_BUTTON = page.locator("#subscribe");
    private final Locator SUCCESS_SUBSCRIBE_MESSAGE = page.locator("div.alert-success.alert");

    public FooterPage(Page page) {
        super(page);
    }

    @Step("Check that user is subscribed")
    public void checkUserIsSubscribed(SubscriptionPageModel subscriptionPageModel, String message){
        SUBSCRIBE_FIELD.fill(subscriptionPageModel.getUserEmailAddress());
        SUBSCRIBE_BUTTON.click();
        String actualText = SUCCESS_SUBSCRIBE_MESSAGE.innerText();
        assertEquals(message, actualText);
    }

}
