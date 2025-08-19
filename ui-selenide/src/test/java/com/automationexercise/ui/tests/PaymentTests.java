package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.PaymentPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentTests {
    private String title = "ORDER PLACED!";
    private String emptyInfoMessage = "Заполните это поле.";
    private String expectedMainURL = "https://automationexercise.com/";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "Pay and confirm order with correct data")
    void payAndConfirmOrderWithCorrectData() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentForm(new PaymentPageModel().existPaymentData())
                .checkPlaceOrderTitle(title);
    }

    @Test(description = "Verify info message when name on card is empty")
    void verifyInfoMessageWhenNameOnCardIsEmpty() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyName(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenNameOnCardIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when card number is empty")
    void verifyInfoMessageWhenCardNumberIsEmpty() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyCardNumber(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenCardNumberIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when cvc is empty")
    void verifyInfoMessageWhenCVCIsEmpty() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyCVC(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenCVCIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when month is empty")
    void verifyInfoMessageWhenMonthIsEmpty() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyMonth(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenMonthIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when year is empty")
    void verifyInfoMessageWhenYearIsEmpty() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyYear(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenYearIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify user is on the main page after finish payment")
    void verifyUserIsOnTheMainPageAfterFinishPayment() {
        new MainPage().acceptCookies();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentForm(new PaymentPageModel().existPaymentData())
                .clickContinueButton().checkUrlOnTheMainPage(expectedMainURL);
    }
}
