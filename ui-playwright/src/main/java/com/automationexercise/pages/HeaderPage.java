package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HeaderPage extends BasePage{
    private final Locator LOGO = page.locator("//div[@class=\"logo pull-left\"]");
    private final Locator HOME_BUTTON = page.locator(".fa.fa-home");
    private final Locator PRODUCTS_BUTTON = page.locator("a[href='/products']");
    private final Locator CART_BUTTON = page.locator(".fa.fa-shopping-cart").first();
    private final Locator LOGIN_BUTTON = page.locator("text=Signup / Login");
    private final Locator DELETE_ACCOUNT_BUTTON = page.locator(".fa.fa-trash-o");



    public HeaderPage(Page page) {
        super(page);
    }

    @Step("Click the logo button on the header")
    public MainPage clickLogo(){
        LOGO.click();
        return new MainPage(page);
    }

    @Step("Click the Home button on the header")
    public MainPage clickHomeButton(){
        HOME_BUTTON.click();
        return new MainPage(page);
    }

    @Step("User click login button")
    public LoginPage clickLoginButton() {
        LOGIN_BUTTON.click();
        return new LoginPage(page);
    }

    @Step("Click the Products button on the header")
    public ProductsPage clickProductsButton(){
        PRODUCTS_BUTTON.click();
        return new ProductsPage(page);
    }

    @Step("Click the Cart button on the header")
    public CartPage clickCartButton(){
        CART_BUTTON.click();
        return new CartPage(page);
    }

    @Step("Click the Delete button on the header")
    public DeletePage clickDeleteAccountButton(){
        DELETE_ACCOUNT_BUTTON.click();
        return new DeletePage(page);
    }
}
