package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage extends BasePage{
    private final By LOGO = By.xpath("//div[@class=\"logo pull-left\"]");
    private final By HOME_BUTTON = By.cssSelector(".fa.fa-home");
    private final By PRODUCTS_BUTTON = By.cssSelector("[href=\"/products\"]");
    private final By CART_BUTTON = By.cssSelector("[class=\"fa fa-shopping-cart\"]");
    private final By LOGIN_LOGOUT_BUTTON = By.cssSelector(".fa.fa-lock");
    private final By DELETE_ACCOUNT_BUTTON = By.cssSelector("[class=\"fa fa-trash-o\"]");
    private final By TEST_CASES_BUTTON = By.cssSelector("[href=\"/test_cases\"]");
    private final By API_TESTING_BUTTON = By.cssSelector("[href=\"/api_list\"]");
    private final By VIDEO_TUTORIALS_BUTTON = By.cssSelector("[href=\"https://www.youtube.com/c/AutomationExercise\"]");
    private final By CONTACT_US_BUTTON = By.cssSelector("[href=\"/contact_us\"]");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the logo button on the header")
    public MainPage clickLogo(){
        waitUntilClickable(LOGO).click();
        return new MainPage(driver);
    }

    @Step("Click the Home button on the header")
    public MainPage clickHomeButton(){
        waitUntilClickable(HOME_BUTTON).click();
        return new MainPage(driver);
    }

    @Step("Click the Products button on the header")
    public ProductsPage clickProductsButton(){
        waitUntilClickable(PRODUCTS_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Click the Cart button on the header")
    public CartPage clickCartButton(){
        waitUntilClickable(CART_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Click the login/logout button on the header")
    public LoginPage clickLoginLogoutButton(){
        waitUntilClickable(LOGIN_LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Click the Delete button on the header")
    public DeletePage clickDeleteAccountButton(){
        waitUntilClickable(DELETE_ACCOUNT_BUTTON).click();
        return new DeletePage(driver);
    }

    @Step("Click the TestCases button on the header")
    public TestCasesPage clickTestCasesButton(){
        waitUntilClickable(TEST_CASES_BUTTON).click();
        return new TestCasesPage(driver);
    }

    @Step("Click the APITesting button on the header")
    public APITestingPage clickAPITestingButton(){
        waitUntilClickable(API_TESTING_BUTTON).click();
        return new APITestingPage(driver);
    }

    @Step("Click the Video Tutorials button on the header")
    public VideoTutorialsPage clickVideoTutorialsButton(){
        waitUntilClickable(VIDEO_TUTORIALS_BUTTON).click();
        return new VideoTutorialsPage(driver);
    }

    @Step("Click the Contact Us button on the header")
    public ContactUsPage clickContactUsButton(){
        waitUntilClickable(CONTACT_US_BUTTON).click();
        return new ContactUsPage(driver);
    }
}
