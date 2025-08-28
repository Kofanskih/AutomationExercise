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
    private String emptyInfoMessage = "Заполните это поле.";
    private String expectedMainURL = "https://automationexercise.com/";

    @Test(description = "Pay and confirm order with correct data")
    void payAndConfirmOrderWithCorrectData() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
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
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
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
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyCardNumber(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenCardNumberIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when cvc is empty")
    void verifyInfoMessageWhenCVCIsEmpty() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyCVC(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenCVCIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when month is empty")
    void verifyInfoMessageWhenMonthIsEmpty() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyMonth(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenMonthIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify info message when year is empty")
    void verifyInfoMessageWhenYearIsEmpty() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentFormWithEmptyYear(new PaymentPageModel().existPaymentData())
                .checkShowValidationMessageWhenYearIsEmpty(emptyInfoMessage);
    }

    @Test(description = "Verify user is on the main page after finish payment")
    void verifyUserIsOnTheMainPageAfterFinishPayment() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .fillPaymentForm(new PaymentPageModel().existPaymentData())
                .clickContinueButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }
}
