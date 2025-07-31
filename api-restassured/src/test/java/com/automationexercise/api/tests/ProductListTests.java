package com.automationexercise.api.tests;

import com.automationexercise.service.ProductListService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.*;
@Epic("Products")
@Feature("Products list")
@Story("Products list")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-012")
public class ProductListTests {
    private final String PATH_NAME = "products.name";
    private final String PRODUCT_NAME = "Men Tshirt";
    private final String PATH_ID = "products.id";
    private final int PRODUCT_ID = 4;
    private final String PATH_BRAND = "products.brand";
    private final String PRODUCT_BRAND = "Polo";
    private final String PATH_CATEGORY = "products.category.usertype.usertype";
    private final String PRODUCT_CATEGORY = "Men";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE = 405;
    private final String PATH_MESSAGE = "message";
    private final String MESSAGE = "This request method is not supported.";

    @Test(description = "Verify status code and content type")
    public void verifyProductList() throws IOException {
        new ProductListService().sendGetProductListRequest()
                .shouldHave(statusCode(200),contentType("text/html"));
    }

    @Test(description = "Check HTML response contains product name")
    public void checkHtmlResponseContainsProductName() throws IOException {
        new ProductListService()
                .sendGetProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_NAME, PRODUCT_NAME);
    }

    @Test(description = "Check HTML response contains product id")
    public void checkHtmlResponseContainsProductId() throws IOException {
        new ProductListService()
                .sendGetProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_ID, PRODUCT_ID);
    }

    @Test(description = "Check HTML response contains product brand")
    public void checkHtmlResponseContainsProductBrand() throws IOException {
        new ProductListService()
                .sendGetProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_BRAND, PRODUCT_BRAND);
    }

    @Test(description = "Check HTML response contains product category")
    public void checkHtmlResponseContainsProductCategory() throws IOException {
        new ProductListService()
                .sendGetProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_CATEGORY, PRODUCT_CATEGORY);
    }

    @Test(description = "Verify correct response code in product list post request")
    public void verifyResponseCodeInPostRequestForProductList() throws IOException {
        new ProductListService()
                .sendPostProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE);
    }

    @Test(description = "Verify correct info message in product list post request")
    public void verifyMessageInPostRequestForProductList() throws IOException {
        new ProductListService()
                .sendPostProductListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, MESSAGE);
    }

}
