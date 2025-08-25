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
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickTestCasesButton()
                .checkTitleOnTheTestCasesPage(testCasesTitle);
    }
}
