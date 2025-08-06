package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest{
    private String expectedPaymentURL = "https://automationexercise.com/payment";

    @Test
    void placeOrderWithLoggedUser() {
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
                .checkUrlOnThePaymentPage(expectedPaymentURL);
    }

    @Test
    void placeOrderWithNotLoggedUser() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .goToTheLoginPage()
                .fillLoginForm(new LoginPageModel().existUserLogin());
        new HeaderPage(driver)
                .clickCartButton()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .checkUrlOnThePaymentPage(expectedPaymentURL);
    }
}
