package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class BrandListService extends BaseService{
    private final String BRAND_LIST_PATH = "brands.list";

    @Step("API send get brand list request")
    public AssertableResponse sendGetBrandListRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .get(getPath(BRAND_LIST_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }

    @Step("API send put brand list request")
    public AssertableResponse sendPutBrandListRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .put(getPath(BRAND_LIST_PATH))
                        .then().extract().response();
        return new AssertableResponse(response);
    }
}
