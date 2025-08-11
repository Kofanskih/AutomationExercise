package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class MainPage extends BasePage{
    private final SelenideElement ACCEPT_COOKIES_BUTTON = $("[class=\"fc-button-label\"]");
    private final SelenideElement USER_LOGGED_IN_TEXT = $x("//a[contains(text(), 'Logged in as')]");
    private final SelenideElement LOGIN_ERROR_TEXT = $("[style=\"color: red;\"]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $("[class=\"modal-title w-100\"]");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $("[class=\"btn btn-success close-modal btn-block\"]");
    private final SelenideElement MODAL_WINDOW_HIDDEN = $("[class=\"modal fade\"]");
    private final SelenideElement VIEW_PRODUCT_BUTTON = $x("(//i[@class='fa fa-plus-square'])[3]");
    private final SelenideElement MEN_BUTTON = $("[href=\"#Men\"]");
    private final SelenideElement JEANS_MEN_BUTTON = $("[href=\"/category_products/6\"]");
    private final SelenideElement BRANDS_HM_BUTTON = $("[href=\"/brand_products/H&M\"]");
    private final SelenideElement VIEW_CART_BUTTON = $x("//p/a[@href=\"/view_cart\"]");
    private final SelenideElement TEST_CASES_CAROUSEL_BUTTON = $x("//div[@class=\"carousel-inner\"]//a[@href=\"/test_cases\"]");
    private final SelenideElement API_TESTING_CAROUSEL_BUTTON = $x("//div[@class=\"carousel-inner\"]//a[@href=\"/api_list\"]");

    @Step("User accepts cookies")
    public MainPage acceptCookies(){
        ACCEPT_COOKIES_BUTTON.click();
        return new MainPage();
    }

    @Step("Check that user is logged in")
    public void checkUserLoggedIn(String loggedInText){
        USER_LOGGED_IN_TEXT.shouldHave(Condition.partialText(loggedInText));
    }

    @Step("Check login error message")
    public void checkLoginErrorMessage(String loginErrorMessage){
        LOGIN_ERROR_TEXT.shouldHave(Condition.exactTextCaseSensitive(loginErrorMessage));
    }

    @Step("Check URL on the Main page")
    public void checkUrlOnTheMainPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    @Step("Add item to the cart")
    public MainPage addItemToTheCartOnTheMainPage(){
        ADD_ITEM_TO_CART.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return this;
    }

    @Step("Check added item on the Main page")
    public void checkAddedItemOnTheMainPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldBe(Condition.visible, Duration.ofSeconds(1))
                .shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }

    @Step("Click continue shopping button on the modal window on the Main page")
    public MainPage clickContinueShoppingButtonOnTheModalWindowOnTheMainPage(){
        CONTINUE_SHOPPING_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return this;
    }

    @Step("Check that the modal window is closed on the Main page")
    public void checkModalWindowIsClosedOnTheMainPage(){
        MODAL_WINDOW_HIDDEN.shouldBe(Condition.exist);
    }

    @Step("Click view product button on the Main page")
    public MainPage clickViewProductOnTheMainPage(){
        VIEW_PRODUCT_BUTTON.scrollTo().click();
        return this;
    }

    @Step("Check URL on the Product page")
    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    @Step("Click the Men Jeans on the Main page")
    public ProductsPage clickOnTheMenJeansCategoryOnTheMainPage(){
        MEN_BUTTON.click();
        JEANS_MEN_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return new ProductsPage();
    }

    @Step("Click the Brands H&M on the Main page")
    public ProductsPage clickOnTheBrandsNMCategoryOnTheMainPage(){
        BRANDS_HM_BUTTON.scrollTo().click();
        return new ProductsPage();
    }

    @Step("Click the view cart button on the modal window")
    public CartPage clickOnTheViewCartButtonOnTheModalWindow(){
        VIEW_CART_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return new CartPage();
    }

    @Step("Click the Test Cases button on the carousel")
    public TestCasesPage clickOnTheTestCasesButtonOnTheCarousel(){
        TEST_CASES_CAROUSEL_BUTTON.click();
        return new TestCasesPage();
    }

    @Step("Click the API Testing button on the carousel")
    public APITestingPage clickOnTheAPITestingButtonOnTheCarousel(){
        API_TESTING_CAROUSEL_BUTTON.click();
        return new APITestingPage();
    }
}
