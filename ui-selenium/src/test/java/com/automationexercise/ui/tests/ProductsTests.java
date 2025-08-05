package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest{
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";

    @Test
    void searchItemOnTheProductsPage(){
        new MainPage(driver).acceptCookies();
        new HeaderPage(driver).clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedItem);
    }

    @Test
    void addItemToTheCartOnTheProductsPage(){
        new MainPage(driver).acceptCookies();
        new HeaderPage(driver).clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductsPage(addedMessageOnTheModalWindow);

    }
}
