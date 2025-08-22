package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String LOGIN_ERROR_MESSAGE = "Your email or password is incorrect!";
    private final String EMPTY_INFO_MESSAGE = "Заполните это поле.";
    private final String INVALID_EMAIL_INFO_MESSAGE  = "Адрес электронной почты должен содержать символ \"@\"."
            + " В адресе \"1test1testtest.com\" отсутствует символ \"@\".";

    @Test(description = "User can login with correct credentials")
    public void userLogin(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin())
                .checkUserLoggedInText(USER_LOGGED_IN_TEXT);
    }

    @Test(description = "User can't login with incorrect credentials")
    public void userLoginWithIncorrectCredentials(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().incorrectDataLogin());
        new LoginPage(page)
                .checkLoginErrorMessage(LOGIN_ERROR_MESSAGE);
    }

    @Test(description = "User can't login with empty email field")
    public void userLoginWithEmptyEmailField(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginFormWithEmptyEmailField(new LoginPageModel().myLogin())
                .checkShowValidationMessageLoginEmail(EMPTY_INFO_MESSAGE);
    }

    @Test(description = "User can't login with empty password field")
    public void userLoginWithEmptyPasswordField(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginFormWithEmptyPasswordField(new LoginPageModel().myLogin())
                .checkShowValidationMessageWhenPasswordIsEmpty(EMPTY_INFO_MESSAGE);
    }

    @Test(description = "User can't login with invalid email")
    public void userLoginWithInvalidEmail(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().invalidEmailLogin());
        new LoginPage(page)
                .checkShowValidationMessageLoginEmail(INVALID_EMAIL_INFO_MESSAGE);
    }
}
