package com.automationexercise.ui.tests.cartTests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    private String emptyCartTitle = "Cart is empty! Click here to buy products.";
    private String expectedProductsURL = "https://automationexercise.com/products";
    private String expectedCheckoutURL = "https://automationexercise.com/checkout";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void goToTheEmptyCart(){
        new MainPage().acceptCookies();
        new HeaderPage().clickCartButton().checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test
    void goToTheProductsPageUsingHereButtonInTheEmptyCart(){
        new MainPage().acceptCookies();
        new HeaderPage().clickCartButton()
                .clickHereButtonTheCartPage()
                .checkUrlOnTheProductPage(expectedProductsURL);
    }

    @Test
    void deleteItemFromTheCart(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .deleteItemFromTheCart()
                .checkTheCartIsEmpty(emptyCartTitle);

    }

    @Test
    void proceedToCheckoutWithLoggedUser() throws InterruptedException {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin());// through main page
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .checkUrlOnTheCheckoutPage(expectedCheckoutURL);
    }

    @Test
    void proceedToCheckoutWithNotLoggedUser() throws InterruptedException {
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .clickToCheckoutButtonOnTheCartPage()
                .goToTheLoginPage()
                .fillLoginForm(new LoginPageModel().myLogin());
        new HeaderPage().clickCartButton()
                .clickToCheckoutButtonOnTheCartPage()
                .checkUrlOnTheCheckoutPage(expectedCheckoutURL);
    }
}
