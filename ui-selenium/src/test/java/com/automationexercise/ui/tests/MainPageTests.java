package com.automationexercise.ui.tests;

import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{

    @Test
    public void acceptCookies() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

    }
}
