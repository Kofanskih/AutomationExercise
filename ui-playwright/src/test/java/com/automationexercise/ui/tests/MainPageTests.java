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
    private String expectedMainURL = "https://automationexercise.com/";
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedProductURL = "https://automationexercise.com/product_details/3";
    private String menJeansTitle = "MEN - JEANS PRODUCTS";

    @Test(description = "Click logo on the main page")
    void clickLogoOnTheMainPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Click home button on the main page")
    void clickHomeButtonOnTheMainPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickHomeButton()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Add item to the cart on the main page")
    void addItemToTheCartOnTheMainPage() {
        new MainPage(page)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkProductAddedMessage(addedMessageOnTheModalWindow);
    }

    @Test(description = "Click continue shopping after adding item")
    void closeAddedModalWindowOnTheMainPage() {
        new MainPage(page)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .clickContinueShoppingButtonOnTheModalWindowOnTheMainPage()
                .checkModalWindowIsClosedOnTheMainPage();
    }

    @Test(description = "Click view product details on the main page")
    void viewProductDetailsOnTheMainPage(){
        new MainPage(page)
                .acceptCookies()
                .clickViewProductOnTheMainPage()
                .checkUrlOnTheProductPage(expectedProductURL);
    }

    @Test(description = "Go to Men Jeans category from the main page")
    void goToMenJeansCategoryOnTheMainPage(){
        new MainPage(page)
                .acceptCookies()
                .clickOnTheMenJeansCategoryOnTheMainPage()
                .checkTitleOnTheProductPage(menJeansTitle);
    }
}
