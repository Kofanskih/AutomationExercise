package com.automationexercise.ui.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
    private String expectedMainURL = "https://automationexercise.com/";
    private String addedMessageOnTheModalWindow = "Added!";
    private String expectedProductURL = "https://automationexercise.com/product_details/3";
    private String menJeansTitle = "MEN - JEANS PRODUCTS";
    private String brandsHMTitle = "BRAND - H&M PRODUCTS";
    private String cartTitle = "Shopping Cart";
    private String testCasesTitle = "TEST CASES";
    private String apiTestingTitle = "APIS LIST FOR PRACTICE";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void clickLogoOnTheMainPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void clickHomeButtonOnTheMainPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void addItemToTheCartOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkAddedItemOnTheMainPage(addedMessageOnTheModalWindow);

    }

    @Test
    void closeAddedModalWindowOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheMainPage()
                .checkModalWindowIsClosedOnTheMainPage();
    }

    @Test
    void viewProductDetailsOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test
    void goToMenJeansCategoryOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheMenJeansCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(menJeansTitle);
    }

    @Test
    void goToBrandsHMCategoryOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheBrandsNMCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(brandsHMTitle);

    }

    @Test
    void goToTheCartAfterAddingItemOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);

    }

    @Test
    void goToTheTestCasesPageThroughCarouselOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheTestCasesButtonOnTheCarousel()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test
    void goToTheAPITestingPageThroughCarouselOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheAPITestingButtonOnTheCarousel()
                .checkTitleOnTheAPITestingPage(apiTestingTitle);
    }
}


