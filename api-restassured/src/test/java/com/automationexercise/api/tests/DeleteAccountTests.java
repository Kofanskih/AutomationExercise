package com.automationexercise.api.tests;

import com.automationexercise.models.createUser.CreateUserModel;
import com.automationexercise.service.CreateAccountService;
import com.automationexercise.service.DeleteAccountService;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.statusCode;

public class DeleteAccountTests {
    private final String EMAIL = "test123test123test123@test.com";
    private final String INCORRECT_EMAIL = "1test123test123test123@test.com";
    private final String PASSWORD = "12345678";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final int RESPONSE_CODE_404 = 404;
    private final String PATH_MESSAGE = "message";
    private final String ACCOUNT_DELETED_MESSAGE = "Account deleted!";
    private final String ACCOUNT_NOT_FOUND_MESSAGE = "Account not found!";


    @Test
    public void verifyCorrectDeleteAccountResponseCode() throws IOException {
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);

        new DeleteAccountService().sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test
    public void verifyCorrectDeleteAccountInfoMessage() throws IOException {
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);

        new DeleteAccountService().sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_DELETED_MESSAGE);
    }

    @Test
    public void verifyCorrectResponseCodeDeleteAccount() throws IOException {
        new DeleteAccountService().sendDeleteAccountRequest(INCORRECT_EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test
    public void verifyCorrectInfoMessageDeleteAccount() throws IOException {
        new DeleteAccountService().sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_NOT_FOUND_MESSAGE);
    }

}
