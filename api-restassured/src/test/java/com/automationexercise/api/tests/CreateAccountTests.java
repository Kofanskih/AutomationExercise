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

    @Test
    public void verifyCreateUserCorrectInfoMessage() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_CREATED_MESSAGE);
    }


}
