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


    @Test
    public void verifyUpdateUserCorrectInfoMessage() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();
        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_UPDATED_MESSAGE);
    }


}
