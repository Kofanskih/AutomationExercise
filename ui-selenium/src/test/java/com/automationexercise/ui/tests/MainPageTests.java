package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Products")
@Feature("Main page")
@Story("Main page")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-003")
public class MainPageTests extends BaseTest{
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedMainURL = "https://automationexercise.com/";
    private String expectedProductURL = "https://automationexercise.com/product_details/3";
    private String menJeansTitle = "MEN - JEANS PRODUCTS";
    private String brandsHMTitle = "BRAND - H&M PRODUCTS";
    private String cartTitle = "Shopping Cart";
    private String testCasesTitle = "TEST CASES";
    private String apiTestingTitle = "APIS LIST FOR PRACTICE";

    @Test(description = "Click logo on the main page")
    void clickLogoOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Click home button on the main page")
    void clickHomeButtonOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Add item to the cart on the main page")
    void addItemToTheCartOnTheMainPage() {
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkProductAddedMessage(addedMessageOnTheModalWindow);
    }

    @Test(description = "Click continue shopping after adding item")
    void closeAddedModalWindowOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheMainPage()
                .checkModalWindowIsClosedOnTheMainPage();
    }

    @Test(description = "Click view product details on the main page")
    void viewProductDetailsOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test(description = "Go to Men Jeans category from the main page")
    void goToMenJeansCategoryOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheMenJeansCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(menJeansTitle);
    }

    @Test(description = "Go to Brands H&M category from the main page")
    void goToBrandsHMCategoryOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheBrandsNMCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(brandsHMTitle);
    }

    @Test(description = "Go to the cart after adding item on the main page")
    void goToTheCartAfterAddingItemOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickOnTheViewCartButtonOnTheModalWindow()
                .checkUserOnTheCartPage(cartTitle);
    }

    @Test(description = "Go to the Test cases page through button on the carousel on the main page")
    void goToTheTestCasesPageThroughCarouselOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheTestCasesButtonOnTheCarousel()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test(description = "Go to the API Testing page through button on the carousel on the main page")
    void goToTheAPITestingPageThroughCarouselOnTheMainPage(){
        new MainPage(driver)
                .acceptCookies()
                .clickOnTheAPITestingButtonOnTheCarousel()
                .checkTitleOnTheAPITestingPage(apiTestingTitle);
    }
}
