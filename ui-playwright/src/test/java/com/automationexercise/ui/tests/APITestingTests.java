package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Test cases")
@Feature("Api test cases")
@Story("Test cases for API")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-009")
public class APITestingTests extends BaseTest{
    private String APITestingTitle = "APIS LIST FOR PRACTICE";

    @Test(description = "User go to the API Testing page")
    void goToTheAPITestingPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickAPITestingButton()
                .checkTitleOnTheAPITestingPage(APITestingTitle);
    }

}
