package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{
    private String emptyCartTitle = "Cart is empty!";

    @Test
    void goToTheEmptyCart(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickCartButton()
                .checkTheCartIsEmpty(emptyCartTitle);
    }

}
