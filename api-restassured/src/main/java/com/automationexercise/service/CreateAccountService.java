package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static utils.GetPath.getPath;

public class CreateAccountService extends BaseService{
    private final String CREATE_ACCOUNT_PATH = "create.account";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    @Step("API send post create user request")
    public AssertableResponse sendPostCreateUserRequest(Map<String, String> userData) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParams(userData)
                        .post(getPath(CREATE_ACCOUNT_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
