package com.automationexercise.ui.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Epic("Products")
@Feature("Main page")
@Story("Main page")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-003")
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

    @Test(description = "Click logo on the main page")
    void clickLogoOnTheMainPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Click home button on the main page")
    void clickHomeButtonOnTheMainPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Add item to the cart on the main page")
    void addItemToTheCartOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkAddedItemOnTheMainPage(addedMessageOnTheModalWindow);

    }

    @Test(description = "Click continue shopping after adding item")
    void closeAddedModalWindowOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheMainPage()
                .checkModalWindowIsClosedOnTheMainPage();
    }

    @Test(description = "Click view product details on the main page")
    void viewProductDetailsOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test(description = "Go to Men Jeans category from the main page")
    void goToMenJeansCategoryOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheMenJeansCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(menJeansTitle);
    }

    @Test(description = "Go to Brands H&M category from the main page")
    void goToBrandsHMCategoryOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheBrandsNMCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(brandsHMTitle);

    }

    @Test(description = "Go to the cart after adding item on the main page")
    void goToTheCartAfterAddingItemOnTheMainPage(){
        new MainPage().acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);

    }

    @Test(description = "Go to the Test cases page through button on the carousel on the main page")
    void goToTheTestCasesPageThroughCarouselOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheTestCasesButtonOnTheCarousel()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test(description = "Go to the API Testing page through button on the carousel on the main page")
    void goToTheAPITestingPageThroughCarouselOnTheMainPage(){
        new MainPage().acceptCookies()
                .clickOnTheAPITestingButtonOnTheCarousel()
                .checkTitleOnTheAPITestingPage(apiTestingTitle);
    }
}


