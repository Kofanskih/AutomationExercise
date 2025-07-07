package com.automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage extends BasePage {
    private final SelenideElement SEARCH_FIELD = $("[id=\"search_product\"]");
    private final SelenideElement SEARCH_BUTTON = $("[id=\"submit_search\"]");
    private final SelenideElement SEARCH_RESULT = $x("//p[contains(., 'Winter Top')]");
    private final SelenideElement ADD_ITEM_TO_CART = $("[data-product-id=\"3\"]");
    private final SelenideElement ADDED_MODAL_WINDOW = $("[class=\"modal-title w-100\"]");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $("[class=\"btn btn-success close-modal btn-block\"]");
    private final SelenideElement MODAL_WINDOW_HIDDEN = $("[class=\"modal fade\"]");
    private final SelenideElement VIEW_PRODUCT_BUTTON = $x("(//i[@class='fa fa-plus-square'])[2]");

    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        SEARCH_FIELD.setValue(searchedItem);
        SEARCH_BUTTON.click();
        return this;
    }

    public void checkSearchedItemOnTheProductPage(String searchedItem){
        SEARCH_RESULT.shouldHave(Condition.exactTextCaseSensitive(searchedItem));
    }

    public ProductsPage addItemToTheCartOnTheProductsPage(){
        ADD_ITEM_TO_CART.scrollTo().click();
        return this;
    }

    public void checkAddedItemOnTheProductPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }

    public ProductsPage closeAddedModalWindowOnTheProductsPage(){
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    public void checkModalWindowIsClosedOnTheProductPage(){
        MODAL_WINDOW_HIDDEN.exists();
    }




    //view product
    // Women - Saree Products
    //Brand - Kookie Kids Products
}
