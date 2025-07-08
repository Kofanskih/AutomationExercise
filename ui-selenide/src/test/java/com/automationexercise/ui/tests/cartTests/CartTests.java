package com.automationexercise.ui.tests.cartTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    private String emptyCartTitle = "Cart is empty! Click here to buy products.";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void goToTheEmptyCart(){
        new MainPage().acceptCookies();
        new HeaderPage().clickCartButton().checkTheCartIsEmpty(emptyCartTitle);
    }
}
