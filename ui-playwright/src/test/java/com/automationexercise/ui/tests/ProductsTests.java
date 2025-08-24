package com.automationexercise.ui.tests;

import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Products")
@Feature("Products list")
@Story("Work with products")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-004")
public class ProductsTests extends BaseTest{
    private String searchedItem = "Winter Top";
    private String searchedResult = "Winter Top";

    @Test(description = "Search item on the Products page")
    void searchItemOnTheProductsPage(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickProductsButton()
                .searchItemOnTheProductsPage(searchedItem)
                .checkSearchedItemOnTheProductsPage(searchedResult);
    }
}
