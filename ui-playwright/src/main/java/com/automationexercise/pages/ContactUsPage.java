package com.automationexercise.pages;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class ContactUsPage extends BasePage{
    private final Locator NAME_FIELD = page.locator("[data-qa='name']");
    private final Locator EMAIL_FIELD = page.locator("[data-qa='email']");
    private final Locator SUBJECT_FIELD = page.locator("[data-qa='subject']");
    private final Locator MESSAGE_FIELD = page.locator("[data-qa='message']");
    private final Locator SUBMIT_BUTTON = page.locator("[data-qa='submit-button']");
    private final Locator ALERT_SUCCESS = page.locator(".status.alert.alert-success");

    public ContactUsPage(Page page) {
        super(page);
    }

    @Step("Fill message form")
    public ContactUsPage fillMessageFormAndAcceptAlert(ContactUsPageModel contactUsPageModel){
        NAME_FIELD.fill(contactUsPageModel.getUserName());
        EMAIL_FIELD.fill(contactUsPageModel.getUserEmailAddress());
        SUBJECT_FIELD.fill(contactUsPageModel.getUserSubject());
        MESSAGE_FIELD.fill(contactUsPageModel.getUserMessage());
        clickOKButton();
        SUBMIT_BUTTON.click();
        return this;
    }

    @Step("Click OK button")
    public ContactUsPage clickOKButton() {
        page.onDialog(dialog -> dialog.accept());
        return this;
    }

    @Step("Check the message was sent")
    public void checkMessageWasSent(String title) {
        ALERT_SUCCESS.waitFor();
        String actualText = ALERT_SUCCESS.textContent().trim();
        assertEquals(actualText, title);
    }
}
