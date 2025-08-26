package com.automationexercise.pages;

import com.automationexercise.pageModels.PaymentPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

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
}
