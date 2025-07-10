package com.automationexercise.ui.tests.productsTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Added!";
    private String expectedProductURL = "https://automationexercise.com/product_details/2";
    private String kidsCategoryTitle = "KIDS - TOPS & SHIRTS PRODUCTS";
    private String madameCategoryTitle = "BRAND - MADAME PRODUCTS";
    private String cartTitle = "Shopping Cart";


    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
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
                .checkUrlOnTheProductPage(expectedProductURL);

    }

    @Test
    void goToTopsShirtsKidsCategoryOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickOnTheKidsTopsCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(kidsCategoryTitle);

    }

    @Test
    void goToBrandsMadameCategoryOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickOnTheBrandsMadameCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(madameCategoryTitle);

    }

    @Test
    void goToTheCartAfterAddingItemOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);

    }
}
