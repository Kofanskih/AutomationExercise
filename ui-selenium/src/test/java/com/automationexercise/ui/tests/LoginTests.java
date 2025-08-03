package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String EMPTY_INFO_MESSAGE = "Заполните это поле.";
    private final String LOGIN_ERROR_MESSAGE = "Your email or password is incorrect!";

    @Test
    public void userLogin(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithExistsUser(new LoginPageModel().existUserLogin())
                .checkUserLoggedIn(USER_LOGGED_IN_TEXT);
    }

    @Test
    public void userLoginWithIncorrectCredentials(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithExistsUser(new LoginPageModel().incorrectDataLogin());
        new LoginPage(driver)
                .checkErrorMessage(LOGIN_ERROR_MESSAGE);
    }

    @Test
    public void userLoginWithEmptyEmailField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithEmptyEmailField(new LoginPageModel().existUserLogin())
                .checkShowValidationMessageWhenLoginEmailIsEmpty(EMPTY_INFO_MESSAGE);
    }

    @Test
    public void userLoginWithEmptyPasswordField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithEmptyPasswordField(new LoginPageModel().existUserLogin())
                .checkShowValidationMessageWhenLoginPasswordIsEmpty(EMPTY_INFO_MESSAGE);
    }

}
