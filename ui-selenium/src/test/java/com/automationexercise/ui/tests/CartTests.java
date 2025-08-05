package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{
    private String emptyCartTitle = "Cart is empty!";
    private String expectedProductsURL = "https://automationexercise.com/products";
    private String expectedCheckoutURL = "https://automationexercise.com/checkout";

    @Test
    void goToTheEmptyCart(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickCartButton()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test
    void goToTheProductsPageUsingHereButtonInTheEmptyCart(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickCartButton()
                .clickHereButtonTheCartPage()
                .checkUrlOnTheProductPage(expectedProductsURL);
    }

    @Test
    void deleteItemFromTheCart() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .deleteItemFromTheCart()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test
    void proceedToCheckoutWithLoggedUser() {
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
                .checkUrlOnTheCheckoutPage(expectedCheckoutURL);
    }

    @Test
    void proceedToCheckoutWithNotLoggedUser() {
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
                .checkUrlOnTheCheckoutPage(expectedCheckoutURL);
    }

}
