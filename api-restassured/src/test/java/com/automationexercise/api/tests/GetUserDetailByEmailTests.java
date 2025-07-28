package com.automationexercise.api.tests;

import com.automationexercise.service.GetUserDetailByEmailService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;

public class GetUserDetailByEmailTests  {
    private final String PATH_EMAIL = "user.email";
    private final String EXIST_USER_EMAIL = "test1234567890test@test.com";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 20;

    @Test
    public void verifyProductList() throws IOException {
        new GetUserDetailByEmailService().sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200)).shouldHave(contentType("text/html"));
    }

    @Test
    public void verifyCorrectInfoMessageForExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_EMAIL, EXIST_USER_EMAIL);
    }

    @Test
    public void verifyCorrectResponseCodeForExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }
}
