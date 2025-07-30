package com.automationexercise.api.tests;

import com.automationexercise.service.GetUserDetailByEmailService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;

public class GetUserDetailByEmailTests  {
    private final String PATH_EMAIL = "user.email";
    private final String EXIST_USER_EMAIL = "test1234567890test@test.com";
    private final String NOT_EXIST_USER_EMAIL = "1test1234567890test@test.com";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final int RESPONSE_CODE_404 = 404;
    private final String PATH_MESSAGE = "message";
    private final String ACCOUNT_NOT_FOUND_INFO_MESSAGE = "Account not found with this email, try another email!";

    @Test(description = "Verify status code and content type")
    public void verifyGetUserDetailByEmail() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200),contentType("text/html"));
    }

    @Test(description = "Verify correct info message for exist user")
    public void verifyCorrectInfoMessageForExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_EMAIL, EXIST_USER_EMAIL);
    }

    @Test(description = "Verify correct response code for exist user")
    public void verifyCorrectResponseCodeForExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test(description = "Verify correct info message for not exist user")
    public void verifyCorrectInfoMessageForNotExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(NOT_EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_NOT_FOUND_INFO_MESSAGE);
    }

    @Test(description = "Verify correct response code for not exist user")
    public void verifyCorrectResponseCodeForNotExistUser() throws IOException {
        new GetUserDetailByEmailService()
                .sendGetUserDetailByEmailRequest(NOT_EXIST_USER_EMAIL)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }
}
