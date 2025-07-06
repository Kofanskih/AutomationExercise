package com.automationexercise.ui.tests.productsTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Added!";


    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void searchItemOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductPage(searchedItem);
    }

    @Test
    void addItemToTheCartOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductPage(addedMessageOnTheModalWindow);

    }
}
