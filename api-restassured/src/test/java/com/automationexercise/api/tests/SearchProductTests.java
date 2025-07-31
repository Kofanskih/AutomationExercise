package com.automationexercise.api.tests;

import com.automationexercise.service.SearchProductService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("Products")
@Feature("Search product")
@Story("Search product")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-013")
public class SearchProductTests {
    private final String SEARCH_PATH = "products.name";
    private final String SEARCH_REQUEST = "TOP";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE = 400;
    private final String PATH_MESSAGE = "message";
    private final String MESSAGE = "Bad request, search_product parameter is missing in POST request.";

    @Test(description = "Verify status code and content type")
    public void verifySearchProduct() throws IOException {
        new SearchProductService()
                .sendPostSearchProductRequest(SEARCH_REQUEST)
                .shouldHave(statusCode(200), contentType("text/html"));
    }

    @Test(description = "Check HTML response contains searched product")
    public void verifyCorrectSearch() throws IOException {
        new SearchProductService()
                .sendPostSearchProductRequest(SEARCH_REQUEST)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsSearchedValueInTheList(SEARCH_PATH, SEARCH_REQUEST);
    }

    @Test(description = "Verify correct response code in empty search post request")
    public void verifyResponseCodeInTheEmptySearch() throws IOException {
        new SearchProductService()
                .sendPostEmptySearchRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE);
    }

    @Test(description = "Verify correct info message in empty search post request")
    public void verifyMessageInPutRequestInTheEmptySearch() throws IOException {
        new SearchProductService()
                .sendPostEmptySearchRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, MESSAGE);
    }

}
