package com.automationexercise.ui.tests;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Test cases")
@Feature("UI test cases")
@Story("Test cases for UI")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-010")
public class TestCasesTests {
    private String testCasesTitle = "TEST CASES";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "User go to the Test cases page")
    void goToTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }

    @Test(description = "Expand list on the Test cases page")
    void expandListOnTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .expandCollapsedList()
                .checkTheListIsExpanded();
    }

    @Test(description = "Collapse expanded list on the Test cases page")
    void colapseExpandedListOnTheTestCasesPage(){
        new MainPage().acceptCookies();
        new HeaderPage().clickTestCasesButton()
                .expandCollapsedList()
                .collapseExpandedList()
                .checkTheListIsCollapsed();
    }
}
