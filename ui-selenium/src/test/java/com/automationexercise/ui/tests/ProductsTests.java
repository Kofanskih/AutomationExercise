package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest{
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedProductURL = "https://automationexercise.com/product_details/2";
    private String kidsCategoryTitle = "KIDS - TOPS & SHIRTS PRODUCTS";
    private String madameCategoryTitle = "BRAND - MADAME PRODUCTS";
    private String cartTitle = "Shopping Cart";

    @Test
    void searchItemOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedItem);
    }

    @Test
    void addItemToTheCartOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductsPage(addedMessageOnTheModalWindow);
    }

    @Test
    void closeAddedModalWindowOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage()
                .checkModalWindowIsClosedOnTheProductsPage();
    }

    @Test
    void viewProductDetailsOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .clickViewProductOnTheProductsPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test
    void goToTopsShirtsKidsCategoryOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .clickOnTheKidsTopsCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(kidsCategoryTitle);
    }

    @Test
    void goToBrandsMadameCategoryOnTheProductsPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickProductsButton()
                .clickOnTheBrandsMadameCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(madameCategoryTitle);

    }

    @Test
    void goToTheCartAfterAddingItemOnTheProductsPage() {
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver).clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);

    }
}
