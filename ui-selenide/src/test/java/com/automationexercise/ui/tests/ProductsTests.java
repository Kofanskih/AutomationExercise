package com.automationexercise.ui.tests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Epic("Products")
@Feature("Products list")
@Story("Work with products")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-004")
public class ProductsTests {
    private String searchedItem = "Winter Top";
    private String addedMessageOnTheModalWindow = "Added!";
    private String expectedProductURL = "https://automationexercise.com/product_details/2";
    private String kidsCategoryTitle = "KIDS - TOPS & SHIRTS PRODUCTS";
    private String madameCategoryTitle = "BRAND - MADAME PRODUCTS";
    private String cartTitle = "Shopping Cart";


    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "Search item on the Products page")
    void searchItemOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedItem);
    }

    @Test(description = "Add item to the cart on the Products page")
    void addItemToTheCartOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductsPage(addedMessageOnTheModalWindow);

    }

    @Test(description = "Click continue shopping after adding item")
    void closeAddedModalWindowOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage()
                .checkModalWindowIsClosedOnTheProductsPage();

    }

    @Test(description = "Click view product details on the main page")
    void viewProductDetailsOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickViewProductOnTheProductsPage()
                .checkUrlOnTheProductPage(expectedProductURL);

    }

    @Test(description = "Go to Kids Tops category from the Products page")
    void goToTopsShirtsKidsCategoryOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickOnTheKidsTopsCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(kidsCategoryTitle);

    }

    @Test(description = "Go to Brands Madame category from the Products page")
    void goToBrandsMadameCategoryOnTheProductsPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .clickOnTheBrandsMadameCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(madameCategoryTitle);

    }

    @Test(description = "Go to the cart after adding item on the Products page")
    void goToTheCartAfterAddingItemOnTheProductsPage() {
        new MainPage().acceptCookies();
        new HeaderPage().clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);

    }
}
