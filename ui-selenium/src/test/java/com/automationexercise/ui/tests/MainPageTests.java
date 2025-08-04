package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedMainURL = "https://automationexercise.com/";
    private String expectedProductURL = "https://automationexercise.com/product_details/3";
    private String menJeansTitle = "MEN - JEANS PRODUCTS";
    private String brandsHMTitle = "BRAND - H&M PRODUCTS";
    private String cartTitle = "Shopping Cart";

    @Test
    void clickLogoOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void clickHomeButtonOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void addItemToTheCartOnTheMainPage() {
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkProductAddedMessage(addedMessageOnTheModalWindow);
    }

    @Test
    void closeAddedModalWindowOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheMainPage()
                .checkModalWindowIsClosedOnTheMainPage();
    }

    @Test
    void viewProductDetailsOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test
    void goToMenJeansCategoryOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheMenJeansCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(menJeansTitle);
    }

    @Test
    void goToBrandsHMCategoryOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheBrandsNMCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(brandsHMTitle);
    }

    @Test
    void goToTheCartAfterAddingItemOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);
    }
}
