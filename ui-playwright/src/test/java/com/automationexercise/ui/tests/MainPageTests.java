package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Products")
@Feature("Main page")
@Story("Main page")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-003")
public class MainPageTests extends BaseTest{
    private String expectedMainURL = "https://automationexercise.com/";

    @Test(description = "Click logo on the main page")
    void clickLogoOnTheMainPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLogo()
                .checkUrlOnTheMainPage(expectedMainURL);
    }
}
