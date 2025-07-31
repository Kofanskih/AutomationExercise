package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class VerifyLoginService extends BaseService {
    private final String VERIFY_LOGIN_PATH = "verify.login";
    private final String EMAIL_PARAM = "email";
    private final String PASSWORD_PARAM = "password";
    private final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    @Step("API send post verify login request")
    public AssertableResponse sendPostVerifyLoginRequest(String email, String password) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParams(EMAIL_PARAM, email, PASSWORD_PARAM, password)
                        .post(getPath(VERIFY_LOGIN_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }

    @Step("API send post verify login request only with email param")
    public AssertableResponse sendPostVerifyLoginRequestOnlyWithEmailParam(String email) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParam(EMAIL_PARAM, email)
                        .post(getPath(VERIFY_LOGIN_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }

    @Step("API send post verify login request only with password param")
    public AssertableResponse sendPostVerifyLoginRequestOnlyWithPasswordParam(String password) throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .formParam(PASSWORD_PARAM, password)
                        .post(getPath(VERIFY_LOGIN_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }

    @Step("API send delete verify login request")
    public AssertableResponse sendDeleteVerifyLoginRequest() throws IOException {
        Response response =
                baseConfiguration()
                        .contentType(X_WWW_FORM_URLENCODED)
                        .delete(getPath(VERIFY_LOGIN_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
