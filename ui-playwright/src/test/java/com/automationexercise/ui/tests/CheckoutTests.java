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
                .checkUrlOnThePaymentPage(expectedPaymentURL);
    }

    @Test(description = "Place order with no logged user")
    void placeOrderWithNotLoggedUser() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .goToTheLoginPage()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage(page)
                .clickCartButton()
                .clickToCheckoutButtonOnTheCartPage()
                .clickPlaceOrderButton()
                .checkUrlOnThePaymentPage(expectedPaymentURL);
    }
}
