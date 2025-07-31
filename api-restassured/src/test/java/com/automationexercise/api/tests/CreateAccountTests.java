package com.automationexercise.api.tests;

import com.automationexercise.models.createUser.CreateUserModel;
import com.automationexercise.service.CreateAccountService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("User login")
@Feature("Account")
@Story("Create account")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-015")
public class CreateAccountTests {
    private final String PATH_MESSAGE = "message";
    private final String USER_CREATED_MESSAGE = "User created!";
    private final String BAD_REQUEST_NAME_MESSAGE = "Bad request, name parameter is missing in POST request.";
    private final String BAD_REQUEST_PASSWORD_MESSAGE = "Bad request, password parameter is missing in POST request.";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_201 = 201;
    private final int RESPONSE_CODE_400 = 400;

    @Test(description = "Verify status code and content type")
    public void verifyCreateAccount() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200),contentType("text/html"));
    }

    @Test(description = "Verify correct info message after create user")
    public void verifyCorrectInfoMessageAfterCreateUser() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_CREATED_MESSAGE);
    }

    @Test(description = "Verify correct response code after create user")
    public void verifyCorrectResponseCodeAfterCreateUser() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_201);
    }

    @Test(description = "Verify correct info message without name in create user form")
    public void verifyCorrectInfoMessageWithoutNameInCreateUserForm() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        userData.remove("name");
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, BAD_REQUEST_NAME_MESSAGE);
    }

    @Test(description = "Verify correct response code without name in create user form")
    public void verifyCorrectResponseCodeWithoutNameInCreateUserForm() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        userData.remove("name");
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_400);
    }

    @Test(description = "Verify correct info message without password in create user form")
    public void verifyCorrectInfoMessageWithoutPasswordInCreateUserForm() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        userData.remove("password");
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, BAD_REQUEST_PASSWORD_MESSAGE);
    }

    @Test(description = "Verify correct response code without password in create user form")
    public void verifyCorrectResponseCodeWithoutPasswordInCreateUserForm() throws IOException {
        CreateUserModel user = new CreateUserModel().getRandomCreateUserData();
        Map<String, String> userData = user.toMap();
        userData.remove("password");
        new CreateAccountService()
                .sendPostCreateUserRequest(userData)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_400);
    }
}
