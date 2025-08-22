package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String LOGIN_ERROR_MESSAGE = "Your email or password is incorrect!";
    private final String EMPTY_INFO_MESSAGE = "1Заполните это поле.";


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
                .checkShowValidationMessageWhenLoginEmailIsEmpty(EMPTY_INFO_MESSAGE);
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

}
