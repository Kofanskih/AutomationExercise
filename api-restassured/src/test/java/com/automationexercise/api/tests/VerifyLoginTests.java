package com.automationexercise.api.tests;

import com.automationexercise.service.VerifyLoginService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.statusCode;

public class VerifyLoginTests {
    private final String CORRECT_LOGIN = "1test1test@test.com";
    private final String CORRECT_PASSWORD = "12345678";
    private final String INCORRECT_LOGIN = "11test1test@test.com";
    private final String INCORRECT_PASSWORD = "123456789";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final int RESPONSE_CODE_404 = 404;
    private final int RESPONSE_CODE_400 = 400;
    private final String PATH_MESSAGE = "message";
    private final String USER_EXISTS_MESSAGE = "User exists!";
    private final String USER_NOT_FOUND_MESSAGE = "User not found!";
    private final String BAD_REQUEST_MESSAGE = "Bad request, email or password parameter is missing in POST request.";


    @Test
    public void verifyCorrectLoginMessage() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_EXISTS_MESSAGE);
    }

    @Test
    public void verifyCorrectLoginResponseCode() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test
    public void verifyCorrectLoginMessageWithInvalidEmail() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(INCORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_NOT_FOUND_MESSAGE);
    }

    @Test
    public void verifyCorrectLoginResponseCodeWithInvalidEmail() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(INCORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test
    public void verifyCorrectMessageLoginWithInvalidPassword() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, INCORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_NOT_FOUND_MESSAGE);
    }

    @Test
    public void verifyCorrectLoginResponseCodeWithInvalidPassword() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, INCORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test
    public void verifyCorrectLoginMessageOnlyWithEmailParam() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithEmailParam(CORRECT_LOGIN)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, BAD_REQUEST_MESSAGE);
    }

    @Test
    public void verifyCorrectLoginResponseCodeOnlyWithEmailParam() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithEmailParam(CORRECT_LOGIN)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_400);
    }
}
