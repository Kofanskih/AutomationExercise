package com.automationexercise.api.tests;

import com.automationexercise.models.updateUser.UpdateUserModel;
import com.automationexercise.service.UpdateAccountService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("User login")
@Feature("Account")
@Story("Update account")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-017")
public class UpdateAccountTests {
    private final String PATH_MESSAGE = "message";
    private final String USER_UPDATED_MESSAGE = "User updated!";
    private final String ACCOUNT_NOT_FOUND_MESSAGE = "Account not found!";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final int RESPONSE_CODE_404 = 404;

    @Test(description = "Verify status code and content type")
    public void verifyUpdateUser() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();

        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200), contentType("text/html"));
    }

    @Test(description = "Verify correct info message after update user")
    public void verifyUpdateUserCorrectInfoMessage() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();

        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_UPDATED_MESSAGE);
    }

    @Test(description = "Verify correct response code after update user")
    public void verifyUpdateUserCorrectResponseCode() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateExistsUserData();
        Map<String, String> userData = user.toMap();

        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test(description = "Verify correct info message after update not exist user")
    public void verifyUpdateNotExistUserCorrectInfoMessage() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateNotExistsUserData();
        Map<String, String> userData = user.toMap();

        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_NOT_FOUND_MESSAGE);
    }

    @Test(description = "Verify correct response code after update not exist user")
    public void verifyUpdateNotExistUserCorrectResponseCode() throws IOException {
        UpdateUserModel user = new UpdateUserModel().getRandomUpdateNotExistsUserData();
        Map<String, String> userData = user.toMap();

        new UpdateAccountService()
                .sendPutUpdateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

}
