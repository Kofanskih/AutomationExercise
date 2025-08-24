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

    @Step("Fill subscribe field with invalid email")
    public FooterPage fillSubscribeFieldWithInvalidEmail(SubscriptionPageModel subscriptionPageModel){
        SUBSCRIBE_FIELD.fill(subscriptionPageModel.getUserEmailAddress());
        return this;
    }
    public String getValidationMessage(Locator element) {
        return (String) element.evaluate("el => el.validationMessage");
    }

    @Step("Check validation message if user fill invalid email")
    public void checkShowValidationMessageUsingInvalidEmailForSubscription(String expectedMessage) {
        Locator subscribeField = SUBSCRIBE_FIELD;
        String actualMessage = getValidationMessage(subscribeField);
        assertEquals(expectedMessage, actualMessage);
    }
}
