package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.PaymentPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Complete order")
@Feature("Payment")
@Story("Payment")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-013")
public class PaymentTests extends BaseTest{
    private String title = "ORDER PLACED!";
    private String emptyInfoMessage = "1Заполните это поле.";

    @Test(description = "Pay and confirm order with correct data")
    void payAndConfirmOrderWithCorrectData() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentForm(new PaymentPageModel().existPaymentData())
                .checkPlaceOrderTitle(title);
    }

    @Test(description = "Verify info message when name on card is empty")
    void verifyInfoMessageWhenNameOnCardIsEmpty() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyName(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenNameOnCardIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when card number is empty")
    void verifyInfoMessageWhenCardNumberIsEmpty() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyCardNumber(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenCardNumberIsEmpty(emptyInfoMessage);
    }
}
