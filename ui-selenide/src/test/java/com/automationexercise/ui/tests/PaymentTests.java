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
    private String emptyInfoMessage = "1Заполните это поле.";

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
}
