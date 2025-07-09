package com.automationexercise.ui.tests.mainPageTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
    private String expectedMainURL = "https://automationexercise.com/";
    private String addedMessageOnTheModalWindow = "Added!";

    @BeforeMethod
    void preconditionMethod(){
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

}


