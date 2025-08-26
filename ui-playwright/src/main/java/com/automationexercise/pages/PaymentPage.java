package com.automationexercise.pages;

import com.automationexercise.pageModels.PaymentPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

public class PaymentPage extends BasePage{
    private final Locator NAME_ON_CARD_FIELD = page.locator("[name='name_on_card']");
    private final Locator CARD_NUMBER_FIELD = page.locator("[data-qa='card-number']");
    private final Locator CVC_FIELD = page.locator("[name='cvc']");
    private final Locator EXPIRY_MONTH_FIELD = page.locator("[name='expiry_month']");
    private final Locator EXPIRY_YEAR_FIELD = page.locator("[data-qa='expiry-year']");
    private final Locator PAY_AND_CONFIRM_BUTTON = page.locator("[data-qa='pay-button']");
    private final Locator TITLE = page.locator("[data-qa='order-placed']");


    public PaymentPage(Page page) {
        super(page);
    }

    @Step("Check URL on the Payment page")
    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = page.url();
        assertEquals(actualUrl, expectedUrl);
    }

    @Step("Fill payment form")
    public PaymentPage fillPaymentForm(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.fill(paymentPageModel.getNameOnCard());
        CARD_NUMBER_FIELD.fill(paymentPageModel.getCardNumber());
        CVC_FIELD.fill(paymentPageModel.getCvc());
        EXPIRY_MONTH_FIELD.fill(paymentPageModel.getMonth());
        EXPIRY_YEAR_FIELD.fill(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();
        return this;
    }

    @Step("Check place order title")
    public void checkPlaceOrderTitle(String title) {
        String actualText = TITLE.innerText();
        assertEquals(actualText, title);
    }

    @Step("Fill payment form with empty name on card")
    public PaymentPage fillPaymentFormWithEmptyName(PaymentPageModel paymentPageModel){
        CARD_NUMBER_FIELD.fill(paymentPageModel.getCardNumber());
        CVC_FIELD.fill(paymentPageModel.getCvc());
        EXPIRY_MONTH_FIELD.fill(paymentPageModel.getMonth());
        EXPIRY_YEAR_FIELD.fill(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();

        return this;
    }

    public String getValidationMessage(Locator element) {
        return (String) element.evaluate("el => el.validationMessage");
    }

    @Step("Check validation message if name on card is empty")
    public void checkShowValidationMessageWhenNameOnCardIsEmpty(String expectedMessage) {
        Locator field = NAME_ON_CARD_FIELD;
        String actualMessage = getValidationMessage(field);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty card number")
    public PaymentPage fillPaymentFormWithEmptyCardNumber(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.fill(paymentPageModel.getNameOnCard());
        CVC_FIELD.fill(paymentPageModel.getCvc());
        EXPIRY_MONTH_FIELD.fill(paymentPageModel.getMonth());
        EXPIRY_YEAR_FIELD.fill(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();
        return this;
    }

    @Step("Check validation message if card name is empty")
    public void checkShowValidationMessageWhenCardNumberIsEmpty(String expectedMessage) {
        Locator field = CARD_NUMBER_FIELD;
        String actualMessage = getValidationMessage(field);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty cvc")
    public PaymentPage fillPaymentFormWithEmptyCVC(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.fill(paymentPageModel.getNameOnCard());
        CARD_NUMBER_FIELD.fill(paymentPageModel.getCardNumber());
        EXPIRY_MONTH_FIELD.fill(paymentPageModel.getMonth());
        EXPIRY_YEAR_FIELD.fill(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();
        return this;
    }

    @Step("Check validation message if cvc is empty")
    public void checkShowValidationMessageWhenCVCIsEmpty(String expectedMessage) {
        Locator field = CVC_FIELD;
        String actualMessage = getValidationMessage(field);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty month")
    public PaymentPage fillPaymentFormWithEmptyMonth(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.fill(paymentPageModel.getNameOnCard());
        CARD_NUMBER_FIELD.fill(paymentPageModel.getCardNumber());
        CVC_FIELD.fill(paymentPageModel.getCvc());
        EXPIRY_YEAR_FIELD.fill(paymentPageModel.getYear());
        PAY_AND_CONFIRM_BUTTON.click();
        return this;
    }

    @Step("Check validation message if month is empty")
    public void checkShowValidationMessageWhenMonthIsEmpty(String expectedMessage) {
        Locator field = EXPIRY_MONTH_FIELD;
        String actualMessage = getValidationMessage(field);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty year")
    public PaymentPage fillPaymentFormWithEmptyYear(PaymentPageModel paymentPageModel){
        NAME_ON_CARD_FIELD.fill(paymentPageModel.getNameOnCard());
        CARD_NUMBER_FIELD.fill(paymentPageModel.getCardNumber());
        CVC_FIELD.fill(paymentPageModel.getCvc());
        EXPIRY_MONTH_FIELD.fill(paymentPageModel.getMonth());
        PAY_AND_CONFIRM_BUTTON.click();

        return this;
    }

    @Step("Check validation message if year is empty")
    public void checkShowValidationMessageWhenYearIsEmpty(String expectedMessage) {
        Locator field = EXPIRY_YEAR_FIELD;
        String actualMessage = getValidationMessage(field);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }
}
