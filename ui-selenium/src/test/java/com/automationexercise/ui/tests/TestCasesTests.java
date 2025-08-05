package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class TestCasesTests extends BaseTest{
    private String testCasesTitle = "TEST CASES";

    @Test
    void goToTheTestCasesPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test
    void expandListOnTheTestCasesPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickTestCasesButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

}
