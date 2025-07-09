package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;

public class ProductsPage extends BasePage {
    private final SelenideElement SEARCH_FIELD = $("[id=\"search_product\"]");
    private final SelenideElement SEARCH_BUTTON = $("[id=\"submit_search\"]");
    private final SelenideElement SEARCH_RESULT = $x("//p[contains(., 'Winter Top')]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $("[class=\"modal-title w-100\"]");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $("[class=\"btn btn-success close-modal btn-block\"]");
    private final SelenideElement MODAL_WINDOW_HIDDEN = $("[class=\"modal fade\"]");
    private final SelenideElement VIEW_PRODUCT_BUTTON = $x("(//i[@class='fa fa-plus-square'])[2]");
    private final SelenideElement KIDS_BUTTON = $("[href=\"#Kids\"]");
    private final SelenideElement TOP_SHIRTS_KIDS_BUTTON = $("[href=\"/category_products/5\"]");
    private final SelenideElement CENTER_TEXT_TITLE = $("[class=\"title text-center\"]");
    private final SelenideElement BRANDS_MADAME_BUTTON = $("[href=\"/brand_products/Madame\"]");
    private final SelenideElement VIEW_CART_BUTTON = $x("//p/a[@href=\"/view_cart\"]");


    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        SEARCH_FIELD.setValue(searchedItem);
        SEARCH_BUTTON.click();
        return this;
    }

    public void checkSearchedItemOnTheProductsPage(String searchedItem){
        SEARCH_RESULT.shouldHave(Condition.exactTextCaseSensitive(searchedItem));
    }

    public ProductsPage addItemToTheCartOnTheProductsPage(){
        ADD_ITEM_TO_CART.scrollTo().click();
        return this;
    }

    public void checkAddedItemOnTheProductsPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }

    public ProductsPage clickContinueShoppingButtonOnTheModalWindowOnTheProductsPage(){
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    public void checkModalWindowIsClosedOnTheProductsPage(){
        MODAL_WINDOW_HIDDEN.shouldBe(Condition.exist);
    }

    public ProductsPage clickViewProductOnTheProductsPage(){
        VIEW_PRODUCT_BUTTON.scrollTo().click();
        return this;
    }

    public void checkUrlOnTheProductPage(String expectedUrl){
        String actualUrl = WebDriverRunner.url();
        assertEquals(expectedUrl, actualUrl);
    }

    public ProductsPage clickOnTheKidsTopsCategoryOnTheProductsPage(){
        KIDS_BUTTON.click();
        TOP_SHIRTS_KIDS_BUTTON.click();
        return this;
    }

    public void checkKidsTitleOnTheProductPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public ProductsPage clickOnTheBrandsMadameCategoryOnTheProductsPage(){
        BRANDS_MADAME_BUTTON.scrollTo().click();
        return this;
    }

    public void checkBrandsMadameTitleOnTheProductPage(String title){
        CENTER_TEXT_TITLE.shouldHave(Condition.exactTextCaseSensitive(title));
    }

    public CartPage clickOnTheViewCartButtonOnTheModalWindow(){
        VIEW_CART_BUTTON.click();
        return new CartPage();
    }
}
