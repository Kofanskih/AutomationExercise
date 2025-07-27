package com.automationexercise.api.tests;

import com.automationexercise.models.createUser.CreateUserModel;
import com.automationexercise.service.CreateAccountService;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.statusCode;

public class CreateAccountTests {
    private final String PATH_MESSAGE = "message";
    private final String USER_CREATED_MESSAGE = "User created!";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 201;

    @Test
    public void verifyCreateUserCorrectInfoMessage() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_CREATED_MESSAGE);
    }

    @Test
    public void verifyCreateUserCorrectResponseCode() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

}
