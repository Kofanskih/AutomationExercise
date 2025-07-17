package com.automationexercise.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage extends BasePage{
    private final SelenideElement LOGO = $("[alt=\"Website for automation practice\"]");
    private final SelenideElement HOME_BUTTON = $("[class=\"fa fa-home\"]");
    private final SelenideElement LOGIN_LOGOUT_BUTTON = $("[class=\"fa fa-lock\"]");
    private final SelenideElement PRODUCTS_BUTTON = $("[href=\"/products\"]");
    private final SelenideElement CART_BUTTON = $("[class=\"fa fa-shopping-cart\"]");
    private final SelenideElement DELETE_ACCOUNT_BUTTON = $("[class=\"fa fa-trash-o\"]"); //data-qa="account-deleted" Account Deleted! data-qa="continue-button"(return to home page)
    private final SelenideElement TEST_CASES_BUTTON = $("[href=\"/test_cases\"]");
    private final SelenideElement API_TESTING_BUTTON = $("[href=\"/api_list\"]");
    private final SelenideElement VIDEO_TUTORIALS_BUTTON = $("[href=\"https://www.youtube.com/c/AutomationExercise\"]");
    private final SelenideElement CONTACT_US_BUTTON = $("[href=\"/contact_us\"]");

    @Step("Click the main button on the header")
    public MainPage clickLogo(){
        LOGO.click();
        return new MainPage();
    }

    @Step("Click the Home button on the header")
    public MainPage clickHomeButton(){
        HOME_BUTTON.click();
        return new MainPage();
    }

    @Step("Click the login button on the header")
    public LoginPage clickLoginButton(){
        LOGIN_LOGOUT_BUTTON.click();
        return new LoginPage();
    }

    @Step("Click the Products button on the header")
    public ProductsPage clickProductsButton(){
        PRODUCTS_BUTTON.click();
        return new ProductsPage();
    }

    @Step("Click the Cart button on the header")
    public CartPage clickCartButton(){
        CART_BUTTON.click();
        return new CartPage();
    }

    @Step("Click the Delete button on the header")
    public DeletePage clickDeleteAccountButton(){
        DELETE_ACCOUNT_BUTTON.click();
        return new DeletePage();
    }

    @Step("Click the TestCases button on the header")
    public TestCasesPage clickTestCasesButton(){
        TEST_CASES_BUTTON.click();
        return new TestCasesPage();
    }

    @Step("Click the APITesting button on the header")
    public APITestingPage clickAPITestingButton(){
        API_TESTING_BUTTON.click();
        return new APITestingPage();
    }

    @Step("Click the Video Tutorials button on the header")
    public VideoTutorialsPage clickVideoTutorialsButton(){
        VIDEO_TUTORIALS_BUTTON.click();
        return new VideoTutorialsPage();
    }

    @Step("Click the Contact Us button on the header")
    public ContactUsPage clickContactUsButton(){
        CONTACT_US_BUTTON.click();
        return new ContactUsPage();
    }
}
