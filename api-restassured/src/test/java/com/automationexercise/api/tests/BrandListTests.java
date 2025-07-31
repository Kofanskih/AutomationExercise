package com.automationexercise.api.tests;

import com.automationexercise.service.BrandListService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("Products")
@Feature("Brands list")
@Story("Brands list")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-014")
public class BrandListTests {
    private final String PATH_ID = "brands.id";
    private final int BRAND_ID = 8;
    private final String PATH_BRAND = "brands.brand";
    private final String BRAND = "H&M";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE = 405;
    private final String PATH_MESSAGE = "message";
    private final String MESSAGE = "This request method is not supported.";

    @Test(description = "Verify status code and content type")
    public void verifyBrandsList() throws IOException {
        new BrandListService()
                .sendGetBrandListRequest()
                .shouldHave(statusCode(200))
                .shouldHave(contentType("text/html"));
    }

    @Test(description = "Check HTML response contains brand id")
    public void checkHtmlResponseContainsBrandId() throws IOException {
        new BrandListService()
                .sendGetBrandListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_ID, BRAND_ID);
    }

    @Test(description = "Check HTML response contains brand")
    public void checkHtmlResponseContainsBrand() throws IOException {
        new BrandListService()
                .sendGetBrandListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_BRAND, BRAND);
    }

    @Test(description = "Verify response code in put request for brand list")
    public void verifyResponseCodeInPutRequestForBrandsList() throws IOException {
        new BrandListService()
                .sendPutBrandListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE);
    }

    @Test(description = "Verify message in put request for brand list")
    public void verifyMessageInPuttRequestForBrandsList() throws IOException {
        new BrandListService()
                .sendPutBrandListRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, MESSAGE);
    }

}
