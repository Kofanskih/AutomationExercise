package com.automationexercise.api.tests;

import com.automationexercise.models.createUser.CreateUserModel;
import com.automationexercise.service.CreateAccountService;
import com.automationexercise.service.DeleteAccountService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("User login")
@Feature("Account")
@Story("Delete account")
@Severity(SeverityLevel.MINOR)
@Owner("bukovtseva")
@TmsLink("TC-018")
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

    @Test(description = "Verify status code and content type")
    public void verifyDeleteAccount() throws IOException {
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);

        new DeleteAccountService()
                .sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200),contentType("text/html"));
    }

    @Test(description = "Verify correct response code after deleting account")
    public void verifyCorrectResponseCodeAfterDeletingAccount() throws IOException {
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);

        new DeleteAccountService()
                .sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test(description = "Verify correct info message after deleting account")
    public void verifyCorrectInfoMessageAfterDeletingAccount() throws IOException {
        CreateUserModel user = new CreateUserModel().getCreateUserDataForDeletingAccount();
        Map<String, String> userData = user.toMap();
        new CreateAccountService()
                .sendPostCreateUserRequest(userData);

        new DeleteAccountService()
                .sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_DELETED_MESSAGE);
    }

    @Test(description = "Verify correct response code after deleting not exists account")
    public void verifyCorrectResponseCodeAfterDeletingNotExistsAccount() throws IOException {
        new DeleteAccountService()
                .sendDeleteAccountRequest(INCORRECT_EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test(description = "Verify correct info message after deleting not exists account")
    public void verifyCorrectInfoMessageAfterDeletingNotExistsAccount() throws IOException {
        new DeleteAccountService()
                .sendDeleteAccountRequest(EMAIL, PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, ACCOUNT_NOT_FOUND_MESSAGE);
    }

}
