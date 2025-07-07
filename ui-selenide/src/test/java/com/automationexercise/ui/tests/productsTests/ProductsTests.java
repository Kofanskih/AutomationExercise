package com.automationexercise.ui.tests.productsTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Added!";
    private final String expectedUrl = "https://automationexercise.com/product_details/2";


    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void searchItemOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedItem);
    }

    @Test
    void addItemToTheCartOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductsPage(addedMessageOnTheModalWindow);

    }

    @Test
    void closeAddedModalWindowOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage()
                .checkModalWindowIsClosedOnTheProductsPage();

    }

    @Test
    void viewProductDetailsOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickViewProductOnTheProductsPage()
                .checkTitleOnTheProductPage(expectedUrl);

    }
}
