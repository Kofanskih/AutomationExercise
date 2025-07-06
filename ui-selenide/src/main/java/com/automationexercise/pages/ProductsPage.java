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

    public ProductsPage searchItemOnTheProductsPage(String searchedItem){
        SEARCH_FIELD.setValue(searchedItem);
        SEARCH_BUTTON.click();
        return this;
    }

    public void checkSearchedItemOnTheProductPage(String searchedItem){
        SEARCH_RESULT.shouldHave(Condition.exactTextCaseSensitive(searchedItem));
    }

    public ProductsPage addItemToTheCartOnTheProductsPage(){
        ADD_ITEM_TO_CART.click();
        return this;
    }

    public void checkAddedItemOnTheProductPage(String infoModalMessage){
        ADDED_MODAL_WINDOW.shouldHave(Condition.exactTextCaseSensitive(infoModalMessage));
    }




    //view product
    // Women - Saree Products
    //Brand - Kookie Kids Products
}
