package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Complete order")
@Feature("Checkout")
@Story("Checkout")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-012")
public class CheckoutTests extends BaseTest{
    private String expectedPaymentURL = "https://automationexercise.com/payment";

    @Test(description = "Place order with logged user")
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

    @Test(description = "Place order with no logged user")
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
