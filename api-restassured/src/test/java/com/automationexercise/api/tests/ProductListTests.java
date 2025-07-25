package com.automationexercise.api.tests;

import com.automationexercise.service.ProductListService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.*;

public class ProductListTests {
    private final String PATH_NAME = "products.name";
    private final String PRODUCT_NAME = "Men Tshirt";
    private final String PATH_ID = "products.id";
    private final int PRODUCT_ID = 4;
    private final String PATH_BRAND = "products.brand";
    private final String PRODUCT_BRAND = "Polo";
    private final String PATH_CATEGORY = "products.category.usertype.usertype";
    private final String PRODUCT_CATEGORY = "Men";

    @Test
    public void verifyProductList() throws IOException {
        new ProductListService().sendGetProductListRequest()
                .shouldHave(statusCode(200)).shouldHave(contentType("text/html"));
    }

    @Test
    public void checkHtmlResponseContainsProductName() throws IOException {
        new ProductListService()
                .sendGetProductListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_NAME, PRODUCT_NAME);
    }

    @Test
    public void checkHtmlResponseContainsProductId() throws IOException {
        new ProductListService()
                .sendGetProductListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_ID, PRODUCT_ID);
    }

    @Test
    public void checkHtmlResponseContainsProductBrand() throws IOException {
        new ProductListService()
                .sendGetProductListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_BRAND, PRODUCT_BRAND);
    }

    @Test
    public void checkHtmlResponseContainsProductCategory() throws IOException {
        new ProductListService()
                .sendGetProductListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_CATEGORY, PRODUCT_CATEGORY);
    }

}
