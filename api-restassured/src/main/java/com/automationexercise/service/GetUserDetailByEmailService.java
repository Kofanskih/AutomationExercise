package com.automationexercise.service;

import com.automationexercise.conditions.AssertableResponse;
import io.restassured.response.Response;

import java.io.IOException;

import static utils.GetPath.getPath;

public class GetUserDetailByEmailService extends BaseService{
    private final String GET_USER_DETAIL_BY_EMAIL_PATH = "get.user.detail.by.email";
    private final String EMAIL_PARAM = "email";

    public AssertableResponse sendGetUserDetailByEmailRequest(String email) throws IOException {
        Response response =
                baseConfiguration()
                        .param(EMAIL_PARAM, email)
                        .get(getPath(GET_USER_DETAIL_BY_EMAIL_PATH))
                        .then()
                        .extract()
                        .response();
        return new AssertableResponse(response);
    }
}
