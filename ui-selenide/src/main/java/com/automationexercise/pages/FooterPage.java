package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class FooterPage extends BasePage{
    private final SelenideElement SUBSCRIBE_FIELD = $("[id=\"susbscribe_email\"]");
    private final SelenideElement SUBSCRIBE_BUTTON = $("[id=\"subscribe\"]");
    private final SelenideElement SUCCESS_SUBSCRIBE_MESSAGE = $x("//div[@class=\"alert-success alert\"]");

    @Step("Check that user is subscribed")
    public void checkUserIsSubscribed(RegistrationPageModel registrationPageModel, String message){
        SUBSCRIBE_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        SUBSCRIBE_BUTTON.click();
        String actualText = SUCCESS_SUBSCRIBE_MESSAGE.getText();
        assertEquals(message, actualText);
    }

    @Step("Fill subscribe field with invalid email")
    public FooterPage fillSubscribeFieldWithInvalidEmail(RegistrationPageModel registrationPageModel){
        SUBSCRIBE_FIELD.setValue(registrationPageModel.getUserEmailAddress());
        return this;
    }

    @Step("Check validation message if user fill invalid email")
    public void checkShowValidationMessageUsingInvalidEmailForSubscription(String message) {
        String actualMessage = (String) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("return arguments[0].validationMessage;", SUBSCRIBE_FIELD);
        assertEquals(message, actualMessage);
    }
}
