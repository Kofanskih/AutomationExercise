package com.automationexercise.api.tests;

import com.automationexercise.models.updateUser.UpdateUserModel;
import com.automationexercise.service.UpdateAccountService;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.statusCode;

public class UpdateAccountTests {
    private final String PATH_MESSAGE = "message";
    private final String USER_UPDATED_MESSAGE = "User updated!";
    private final String ACCOUNT_NOT_FOUND_MESSAGE = "Account not found!";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;


    @Test
    public void verifyUpdateUserCorrectInfoMessage() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();
        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_UPDATED_MESSAGE);
    }

    @Test
    public void verifyUpdateUserCorrectResponseCode() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();
        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test
    public void verifyUpdateNotExistUserCorrectInfoMessage() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateNotExistsUserData();
        Map<String, String> userData = user.toMap();
        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_NOT_FOUND_MESSAGE);
    }


}
