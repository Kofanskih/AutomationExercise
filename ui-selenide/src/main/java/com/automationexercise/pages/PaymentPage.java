package com.automationexercise.pages;

import com.automationexercise.pageModels.PaymentPageModel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class PaymentPage extends BasePage{
    private final SelenideElement NAME_ON_CARD_FIELD = $("[name=\"name_on_card\"]");
    private final SelenideElement CARD_NUMBER_FIELD = $("[data-qa=\"card-number\"]");
    private final SelenideElement CVC_FIELD = $("[name=\"cvc\"]");
    private final SelenideElement EXPIRY_MONTH_FIELD = $("[name=\"expiry_month\"]");
    private final SelenideElement EXPIRY_YEAR_FIELD = $("[data-qa=\"expiry-year\"]");
    private final SelenideElement PAY_AND_CONFIRM_BUTTON = $("[data-qa=\"pay-button\"]");
    private final SelenideElement TITLE = $("[data-qa=\"order-placed\"]");

    @Step("Check URL on the Payment page")
    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    @Step("Fill payment form")
    public PaymentPage fillPaymentForm(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.setValue(paymentPageModel.getNameOnCard());
        CARD_NUMBER_FIELD.setValue(paymentPageModel.getCardNumber());
        CVC_FIELD.sendKeys(paymentPageModel.getCvc());
        EXPIRY_MONTH_FIELD.sendKeys(paymentPageModel.getMonth());
        EXPIRY_YEAR_FIELD .sendKeys(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();

        return this;
    }

    @Step("Check place order title")
    public void checkPlaceOrderTitle(String title) {
        TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }
}
