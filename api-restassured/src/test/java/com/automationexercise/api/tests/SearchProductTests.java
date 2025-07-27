package com.automationexercise.api.tests;

import com.automationexercise.service.SearchProductService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.statusCode;

public class SearchProductTests {
    private final String SEARCH_PATH = "products.name";
    private final String SEARCH_REQUEST = "TOP";

    @Test
    public void verifyCorrectSearch() throws IOException {
        new SearchProductService()
                .sendPostSearchProductRequest(SEARCH_REQUEST)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsSearchedValueInTheList(SEARCH_PATH, SEARCH_REQUEST);
    }

}
