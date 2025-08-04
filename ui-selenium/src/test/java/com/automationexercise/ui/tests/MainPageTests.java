package com.automationexercise.ui.tests;

import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{
    private String addedMessageOnTheModalWindow = "Your product has been added to cart.";

    @Test
    public void addItemToTheCartOnTheMainPage() {
        new MainPage(driver)
                .acceptCookies()
                .addItemToTheCartOnTheMainPage()
                .checkProductAddedMessage(addedMessageOnTheModalWindow);;
    }
}
