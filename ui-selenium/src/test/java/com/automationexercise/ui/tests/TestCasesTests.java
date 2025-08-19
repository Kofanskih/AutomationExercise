package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Test cases")
@Feature("UI test cases")
@Story("Test cases for UI")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-010")
public class TestCasesTests extends BaseTest{
    private String testCasesTitle = "TEST CASES";

    @Test(description = "User go to the Test cases page")
    void goToTheTestCasesPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test(description = "Expand list on the Test cases page")
    void expandListOnTheTestCasesPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickTestCasesButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

    @Test(description = "Collapse expanded list on the Test cases page")
    void collapseExpandedListOnTheTestCasesPage(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickTestCasesButton()
                .expandCollapsedList()
                .collapseExpandedList()
                .checkTheListIsCollapsed();
    }
}
