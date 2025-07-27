package com.automationexercise.api.tests;

import com.automationexercise.models.createUser.CreateUserModel;
import com.automationexercise.service.CreateAccountService;
import com.automationexercise.service.DeleteAccountService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.statusCode;

public class DeleteAccountTests {
    private final String EMAIL = "test123test123test123@test.com";
    private final String PASSWORD = "12345678";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final String PATH_MESSAGE = "message";
    private final String USER_DELETED_MESSAGE = "Account deleted!";

    @BeforeMethod
    public void createUserForDeleting() throws IOException{
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);
    }

    @Test
    public void verifyCorrectDeleteAccountResponseCode() throws IOException {
        new DeleteAccountService().sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test
    public void verifyCorrectDeleteAccountInfoMessage() throws IOException {
        new DeleteAccountService().sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_DELETED_MESSAGE);
    }

}
