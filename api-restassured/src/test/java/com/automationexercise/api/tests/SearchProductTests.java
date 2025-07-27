package com.automationexercise.api.tests;

import com.automationexercise.service.SearchProductService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.statusCode;

public class SearchProductTests {
    private final String SEARCH_PATH = "products.name";
    private final String SEARCH_REQUEST = "TOP";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE = 400;
    private final String PATH_MESSAGE = "message";
    private final String MESSAGE = "Bad request, search_product parameter is missing in POST request.";

    @Test
    public void verifyCorrectSearch() throws IOException {
        new SearchProductService()
                .sendPostSearchProductRequest(SEARCH_REQUEST)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsSearchedValueInTheList(SEARCH_PATH, SEARCH_REQUEST);
    }

    @Test
    public void verifyResponseCodeInTheEmptySearch() throws IOException {
        new SearchProductService()
                .sendPostEmptySearchRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE);
    }

    @Test
    public void verifyMessageInPutRequestInTheEmptySearch() throws IOException {
        new SearchProductService()
                .sendPostEmptySearchRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, MESSAGE);
    }

}
