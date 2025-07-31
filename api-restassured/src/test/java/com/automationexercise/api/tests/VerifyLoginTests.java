package com.automationexercise.api.tests;

import com.automationexercise.service.VerifyLoginService;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;
@Epic("User login")
@Feature("Account")
@Story("Login")
@Severity(SeverityLevel.BLOCKER)
@Owner("bukovtseva")
@TmsLink("TC-016")
public class VerifyLoginTests {
    private final String CORRECT_LOGIN = "1test1test@test.com";
    private final String CORRECT_PASSWORD = "12345678";
    private final String INCORRECT_LOGIN = "11test1test@test.com";
    private final String INCORRECT_PASSWORD = "123456789";
    private final String PATH_RESPONSE_CODE = "responseCode";
    private final int RESPONSE_CODE_200 = 200;
    private final int RESPONSE_CODE_404 = 404;
    private final int RESPONSE_CODE_400 = 400;
    private final int RESPONSE_CODE_405 = 405;
    private final String PATH_MESSAGE = "message";
    private final String USER_EXISTS_MESSAGE = "User exists!";
    private final String USER_NOT_FOUND_MESSAGE = "User not found!";
    private final String BAD_REQUEST_MESSAGE = "Bad request, email or password parameter is missing in POST request.";
    private final String NOT_SUPPORTED_MESSAGE = "This request method is not supported.";

    @Test(description = "Verify status code and content type")
    public void verifyCorrectLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200), contentType("text/html"));
    }

    @Test(description = "Verify correct info message after post login request")
    public void verifyCorrectLoginInfoMessage() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_EXISTS_MESSAGE);
    }

    @Test(description = "Verify correct response code after post login request")
    public void verifyCorrectLoginResponseCode() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_200);
    }

    @Test(description = "Verify correct info message after post login request with invalid email")
    public void verifyCorrectInfoMessageWithInvalidEmailLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(INCORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_NOT_FOUND_MESSAGE);
    }

    @Test(description = "Verify correct response code after post login request with invalid email")
    public void verifyCorrectResponseCodeWithInvalidEmailLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(INCORRECT_LOGIN, CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test(description = "Verify correct info message after post login request with invalid password")
    public void verifyCorrectInfoMessageWithInvalidPasswordLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, INCORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, USER_NOT_FOUND_MESSAGE);
    }

    @Test(description = "Verify correct response code after post login request with invalid password")
    public void verifyCorrectResponseCodeWithInvalidPasswordLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequest(CORRECT_LOGIN, INCORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_404);
    }

    @Test(description = "Verify correct info message after post login request only with email param")
    public void verifyCorrectInfoMessageOnlyWithEmailParamLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithEmailParam(CORRECT_LOGIN)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, BAD_REQUEST_MESSAGE);
    }

    @Test(description = "Verify correct response code after post login request only with email param")
    public void verifyCorrectLoginResponseCodeOnlyWithEmailParamLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithEmailParam(CORRECT_LOGIN)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_400);
    }

    @Test(description = "Verify correct info message after post login request only with password param")
    public void verifyCorrectInfoMessageOnlyWithPasswordParamLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithPasswordParam(CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, BAD_REQUEST_MESSAGE);
    }

    @Test(description = "Verify correct response code after post login request only with password param")
    public void verifyCorrectResponseCodeOnlyWithPasswordParamLogin() throws IOException {
        new VerifyLoginService()
                .sendPostVerifyLoginRequestOnlyWithPasswordParam(CORRECT_PASSWORD)
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_400);
    }

    @Test(description = "Verify correct info message after delete login request")
    public void verifyCorrectInfoMessageForLoginWithDeleteMethod() throws IOException {
        new VerifyLoginService()
                .sendDeleteVerifyLoginRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_MESSAGE, NOT_SUPPORTED_MESSAGE);
    }

    @Test(description = "Verify correct response code after delete login request")
    public void verifyCorrectResponseCodeForLoginWithDeleteMethod() throws IOException {
        new VerifyLoginService()
                .sendDeleteVerifyLoginRequest()
                .shouldHave(statusCode(200))
                .checkHtmlResponseContainsValue(PATH_RESPONSE_CODE, RESPONSE_CODE_405);
    }
}
