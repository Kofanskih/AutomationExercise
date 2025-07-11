package com.automationexercise.ui.tests.testCasesTests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCasesTests {
    private String testCasesTitle = "TEST CASES";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void goToTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test
    void expandListOnTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

    @Test
    void colapseExpandedListOnTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .expandCollapsedList()
                .collapseExpandedList()
                .checkTheListIsCollapsed();
    }
}
