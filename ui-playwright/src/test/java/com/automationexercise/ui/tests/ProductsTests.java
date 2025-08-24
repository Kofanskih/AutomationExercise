package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Products")
@Feature("Products list")
@Story("Work with products")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-004")
public class ProductsTests extends BaseTest{
    private String searchedItem = "Winter Top";
    private String searchedResult = "Winter Top";
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedProductURL = "https://automationexercise.com/product_details/2";
    private String kidsCategoryTitle = "KIDS - TOPS & SHIRTS PRODUCTS";
    private String madameCategoryTitle = "BRAND - MADAME PRODUCTS";
    private String cartTitle = "Shopping Cart";


    @Test(description = "Search item on the Products page")
    void searchItemOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedResult);
    }

    @Test(description = "Add item to the cart on the Products page")
    void addItemToTheCartOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .checkAddedItemOnTheProductsPage(addedMessageOnTheModalWindow);
    }

    @Test(description = "Click continue shopping after adding item")
    void closeAddedModalWindowOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage()
                .checkModalWindowIsClosedOnTheProductsPage();
    }

    @Test(description = "Click view product details on the products page")
    void viewProductDetailsOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test(description = "Go to Kids Tops category from the Products page")
    void goToTopsShirtsKidsCategoryOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .clickOnTheKidsTopsCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(kidsCategoryTitle);
    }

    @Test(description = "Go to Brands Madame category from the Products page")
    void goToBrandsMadameCategoryOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .clickOnTheBrandsMadameCategoryOnTheProductsPage()
                .checkTitleOnTheProductPage(madameCategoryTitle);
    }

    @Test(description = "Go to the cart after adding item on the Products page")
    void goToTheCartAfterAddingItemOnTheProductsPage() {
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .addItemToTheCartOnTheProductsPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);
    }
}
