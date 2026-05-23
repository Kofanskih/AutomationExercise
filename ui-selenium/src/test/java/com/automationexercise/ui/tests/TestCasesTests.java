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
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test(description = "Expand list on the Test cases page")
    void expandListOnTheTestCasesPage(){
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickTestCasesButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

    @Test(description = "Collapse expanded list on the Test cases page")
    void collapseExpandedListOnTheTestCasesPage(){
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickTestCasesButton()
                .expandCollapsedList()
                .collapseExpandedList()
                .checkTheListIsCollapsed();
    }
}
