package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Cart")
@Feature("Order")
@Story("Work with orders")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-005")
public class CartTests extends BaseTest{
    private String emptyCartTitle = "Cart is empty!";
    private String expectedProductsURL = "https://automationexercise.com/products";
    private String expectedCheckoutURL = "https://automationexercise.com/checkout";

    @Test(description = "User go to the empty cart")
    void goToTheEmptyCart(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickCartButton()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test(description = "Go to the Products page from the empty cart")
    void goToTheProductsPageUsingHereButtonInTheEmptyCart(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickCartButton()
                .clickHereButtonTheCartPage()
                .checkUrlOnTheProductPage(expectedProductsURL);
    }

    @Test(description = "Delete the item from the cart")
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

    @Test(description = "Logged in user is proceed to checkout")
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

    @Test(description = "Proceed to checkout with no logged in user")
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
