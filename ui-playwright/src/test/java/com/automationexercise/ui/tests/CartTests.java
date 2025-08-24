package com.automationexercise.ui.tests;

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
}
