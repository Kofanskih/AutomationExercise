package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";
    private String expectedMainURL = "https://automationexercise.com/";

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
    public void addItemToTheCartOnTheMainPage() {
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkProductAddedMessage(addedMessageOnTheModalWindow);
    }
}
