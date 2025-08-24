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
    private String expectedCheckoutURL = "1https://automationexercise.com/checkout";

    @Test(description = "User go to the empty cart")
    void goToTheEmptyCart(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickCartButton()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test(description = "Go to the Products page from the empty cart")
    void goToTheProductsPageUsingHereButtonInTheEmptyCart(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickCartButton()
                .clickHereButtonTheCartPage()
                .checkUrlOnTheProductPage(expectedProductsURL);
    }

    @Test(description = "Delete the item from the cart")
    void deleteItemFromTheCart() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .deleteItemFromTheCart()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

    @Test(description = "Logged in user is proceed to checkout")
    void proceedToCheckoutWithLoggedUser() {
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
                .checkUrlOnTheCheckoutPage(expectedCheckoutURL);
    }
}
