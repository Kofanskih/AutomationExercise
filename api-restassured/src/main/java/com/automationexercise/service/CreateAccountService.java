package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import com.automationexercise.models.createUser.CreateUserModel;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class CreateAccountService extends BaseService{
    private final String CREATE_ACCOUNT_PATH = "create.account";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public AssertableResponse sendPostCreateUserRequest(CreateUserModel createUserModel) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParams(createUserModel.toMap())
                        .post(getPath(CREATE_ACCOUNT_PATH))
                        .then().extract().response();
        return new AssertableResponse(response);
    }
}
