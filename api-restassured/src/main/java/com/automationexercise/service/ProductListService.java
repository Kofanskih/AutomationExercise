package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.restassured.response.Response;
import java.io.IOException;

import static utils.GetPath.getPath;

public class ProductListService extends BaseService {
    private final String PRODUCT_LIST_PATH = "product.list";

    public AssertableResponse sendGetProductListRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .get(getPath(PRODUCT_LIST_PATH)).then().extract().response();
        return new AssertableResponse(response);
    }



}
