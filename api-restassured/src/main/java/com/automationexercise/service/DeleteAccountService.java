package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class DeleteAccountService extends BaseService{
    private final String DELETE_ACCOUNT_PATH = "delete.account";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private final String EMAIL_PARAM = "email";
    private final String PASSWORD_PARAM = "password";

    public AssertableResponse sendDeleteAccountRequest(String email, String password) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParams(EMAIL_PARAM, email, PASSWORD_PARAM, password)
                        .delete(getPath(DELETE_ACCOUNT_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
