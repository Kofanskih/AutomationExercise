package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage extends BasePage{
    private final By LOGIN_LOGOUT_BUTTON = By.cssSelector(".fa.fa-lock");
    private final By LOGO = By.xpath("//div[@class=\"logo pull-left\"]");
    private final By HOME_BUTTON = By.cssSelector(".fa.fa-home");
    private final By PRODUCTS_BUTTON = By.cssSelector("[href=\"/products\"]");
    private final By CART_BUTTON = By.cssSelector("[class=\"fa fa-shopping-cart\"]");
    private final By TEST_CASES_BUTTON = By.cssSelector("[href=\"/test_cases\"]");
    private final By API_TESTING_BUTTON = By.cssSelector("[href=\"/api_list\"]");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickLogo(){
        waitUntilClickable(LOGO).click();
        return new MainPage(driver);
    }

    public MainPage clickHomeButton(){
        waitUntilClickable(HOME_BUTTON).click();
        return new MainPage(driver);
    }

    public ProductsPage clickProductsButton(){
        waitUntilClickable(PRODUCTS_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CartPage clickCartButton(){
        waitUntilClickable(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public LoginPage clickLoginLogoutButton(){
        waitUntilClickable(LOGIN_LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    public TestCasesPage clickTestCasesButton(){
        waitUntilClickable(TEST_CASES_BUTTON).click();
        return new TestCasesPage(driver);
    }

    public APITestingPage clickAPITestingButton(){
        waitUntilClickable(API_TESTING_BUTTON).click();
        return new APITestingPage(driver);
    }
}
