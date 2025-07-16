package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class ProductsPage extends BasePage {
    private final SelenideElement SEARCH_FIELD = $("[id=\"search_product\"]");
    private final SelenideElement SEARCH_BUTTON = $("[id=\"submit_search\"]");
    private final SelenideElement SEARCH_RESULT = $x("//p[contains(., 'Winter Top')]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $x("//h4[contains(., 'Added!')]");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $("[class=\"btn btn-success close-modal btn-block\"]");
    private final SelenideElement MODAL_WINDOW_HIDDEN = $("[class=\"modal fade\"]");
    private final SelenideElement VIEW_PRODUCT_BUTTON = $x("(//i[@class='fa fa-plus-square'])[2]");
    private final SelenideElement KIDS_BUTTON = $("[href=\"#Kids\"]");
    private final SelenideElement TOP_SHIRTS_KIDS_BUTTON = $("[href=\"/category_products/5\"]");
    private final SelenideElement CENTER_TEXT_TITLE = $("[class=\"title text-center\"]");
    private final SelenideElement BRANDS_MADAME_BUTTON = $("[href=\"/brand_products/Madame\"]");
    private final SelenideElement VIEW_CART_BUTTON = $x("(//p[@class=\"text-center\"])[2]");

    @Step("Search item on the Products page")
    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        SEARCH_FIELD.setValue(searchedItem);
        SEARCH_BUTTON.click();
        return this;
    }

    @Step("Check searched item on the Products page")
    public void checkSearchedItemOnTheProductsPage(String searchedItem){
        SEARCH_RESULT.shouldHave(Condition.exactTextCaseSensitive(searchedItem));
    }

    @Step("Add item to the cart on the Products page")
    public ProductsPage addItemToTheCartOnTheProductsPage(){
        ADD_ITEM_TO_CART.scrollTo().click();
        return this;
    }

    @Step("Check added item on the Modal window")
    public void checkAddedItemOnTheProductsPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldBe(Condition.visible, Duration.ofSeconds(1))
                .shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }

    @Step("Click continue shopping button on the Modal window")
    public ProductsPage clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage(){
        CONTINUE_SHOPPING_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return this;
    }

    @Step("Check that modal window is closed")
    public void checkModalWindowIsClosedOnTheProductsPage(){
        MODAL_WINDOW_HIDDEN.shouldBe(Condition.exist);
    }

    @Step("Click view product button on the Products page")
    public ProductsPage clickViewProductOnTheProductsPage(){
        VIEW_PRODUCT_BUTTON.scrollTo().click();
        return this;
    }

    @Step("Check URL on the Products page")
    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    @Step("Click on the Kids Tops category on the Products page")
    public ProductsPage clickOnTheKidsTopsCategoryOnTheProductsPage(){
        KIDS_BUTTON.click();
        TOP_SHIRTS_KIDS_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return this;
    }

    @Step("Check title on the product page")
    public void checkTitleOnTheProductPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    @Step("Click on the Brands Madame category on the Products page")
    public ProductsPage clickOnTheBrandsMadameCategoryOnTheProductsPage(){
        BRANDS_MADAME_BUTTON.scrollTo().click();
        return this;
    }

    @Step("Click on the view cart button on the Modal window")
    public CartPage clickOnTheViewCartButtonOnTheModalWindow() {
        VIEW_CART_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        return new CartPage();
    }
}
