package com.automationexercise.api.tests;

import com.automationexercise.service.VerifyLoginService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.statusCode;

public class VerifyLoginTests {
    private final String CORRECT_LOGIN = "1test1test@test.com";
    private final String CORRECT_PASSWORD = "12345678";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE = 200;
    private final String PATH_MESSAGE = "message";
    private final String MESSAGE = "User exists!";


    @Test
    public void verifyCorrectLoginMessage() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, MESSAGE);
    }

    @Test
    public void verifyCorrectLoginResponseCode() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE);
    }
}
