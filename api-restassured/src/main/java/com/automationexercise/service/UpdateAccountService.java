package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static utils.GetPath.getPath;

public class UpdateAccountService extends BaseService{
    private final String UPDATE_ACCOUNT_PATH = "update.account";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public AssertableResponse sendPutUpdateUserRequest(Map<String, String> userData) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParams(userData)
                        .put(getPath(UPDATE_ACCOUNT_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
