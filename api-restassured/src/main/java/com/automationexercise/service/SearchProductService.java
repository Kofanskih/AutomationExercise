package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class SearchProductService extends BaseService {
    private final String SEARCH_PRODUCT_PATH = "search.product";
    private final String PARAM = "search_product";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    @Step("API send post search product request")
    public AssertableResponse sendPostSearchProductRequest(String searchRequest) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParam(PARAM, searchRequest)
                        .post(getPath(SEARCH_PRODUCT_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }

    @Step("API send post empty search request")
    public AssertableResponse sendPostEmptySearchRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .post(getPath(SEARCH_PRODUCT_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
