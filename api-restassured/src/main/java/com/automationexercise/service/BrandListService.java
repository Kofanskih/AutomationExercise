package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class BrandListService extends BaseService{
    private final String BRAND_LIST_PATH = "brands.list";

    public AssertableResponse sendGetBrandListRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .get(getPath(BRAND_LIST_PATH)).then().extract().response();
        return new AssertableResponse(response);
    }


}
