package com.automationexercise.pages;

import com.automationexercise.pageModels.ContactUsPageModel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class ContactUsPage extends BasePage{
    private final SelenideElement NAME_FIELD = $("[data-qa=\"name\"]");
    private final SelenideElement EMAIL_FIELD = $("[data-qa=\"email\"]");
    private final SelenideElement SUBJECT_FIELD = $("[data-qa=\"subject\"]");
    private final SelenideElement MESSAGE_FIELD = $("[data-qa=\"message\"]");
    private final SelenideElement SUBMIT_BUTTON = $("[data-qa=\"submit-button\"]");
    private final SelenideElement ALERT_SUCCESS = $("[class=\"status alert alert-success\"]");
    private final SelenideElement HOME_BUTTON = $("[class=\"fa fa-angle-double-left\"]");

    @Step("Fill message form")
    public ContactUsPage fillMessageForm(ContactUsPageModel contactUsPageModel){
        NAME_FIELD.setValue(contactUsPageModel.getUserName());
        EMAIL_FIELD.setValue(contactUsPageModel.getUserEmailAddress());
        SUBJECT_FIELD.setValue(contactUsPageModel.getUserSubject());
        MESSAGE_FIELD.setValue(contactUsPageModel.getUserMessage());
        SUBMIT_BUTTON.click();
        return this;
    }

    @Step("Click OK button")
    public ContactUsPage clickOKButton(){
        Selenide.switchTo().alert().accept(); // [class="status alert alert-success"] Success! Your details have been submitted successfully. [class="fa fa-angle-double-left"]
        return this;
    }

    @Step("Check the message was sent")
    public void checkMessageWasSent(String message){
        ALERT_SUCCESS.shouldHave(Condition.exactTextCaseSensitive(message));
    }

    @Step("Click Cancel button")
    public ContactUsPage clickCancelButton(){
        Selenide.switchTo().alert().dismiss();
        return this;
    }

    @Step("Check the message was sent")
    public void checkHomeButtonNotAppear(){
        HOME_BUTTON.shouldNot(Condition.exist);
    }

    @Step("Click Home button")
    public MainPage clickHomeButton(){
        HOME_BUTTON.click();
        return new MainPage();
    }

    @Step("Check validation message shows")
    public void checkShowValidationMessageInEmailField(String message) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", EMAIL_FIELD);
        assertEquals(message, actualMessage);
    }

}
