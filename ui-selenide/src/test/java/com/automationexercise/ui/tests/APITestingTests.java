package com.automationexercise.ui.tests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITestingTests {
    private String APITestingTitle = "APIS LIST FOR PRACTICE";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "User go to the API Testing page")
    void goToTheAPITestingPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickAPITestingButton()
                .checkTitleOnTheAPITestingPage(APITestingTitle);
    }

    @Test(description = "Expand list on the API Testing page")
    void expandListOnTheAPITestingPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickAPITestingButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

    @Test(description = "Collapse expanded list on the API Testing page")
    void colapseExpandedListOnTheAPITestingPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickAPITestingButton()
                .expandCollapsedList()
                .collapseExpandedList()
                .checkTheListIsCollapsed();
    }
}
