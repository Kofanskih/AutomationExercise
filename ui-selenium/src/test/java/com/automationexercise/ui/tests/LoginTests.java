package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
@Story("User logs in with different credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-001")
public class LoginTests extends BaseTest{
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String EMPTY_INFO_MESSAGE = "Заполните это поле.";
    private final String LOGIN_ERROR_MESSAGE = "Your email or password is incorrect!";
    private final String INVALID_EMAIL_INFO_MESSAGE  = "Адрес электронной почты должен содержать символ \"@\". В адресе \"1test1testtest.com\" отсутствует символ \"@\".";


    @Test(description = "User can login with correct credentials")
    public void userLogin(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().existUserLogin())
                .checkUserLoggedInText(USER_LOGGED_IN_TEXT);
    }

    @Test(description = "User can't login with incorrect credentials")
    public void userLoginWithIncorrectCredentials(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().incorrectDataLogin());
        new LoginPage(driver)
                .checkLoginErrorMessage(LOGIN_ERROR_MESSAGE);
    }

    @Test(description = "User can't login with empty email field")
    public void userLoginWithEmptyEmailField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithEmptyEmailField(new LoginPageModel().existUserLogin())
                .checkShowValidationMessageWhenLoginEmailIsEmpty(EMPTY_INFO_MESSAGE);
    }

    @Test(description = "User can't login with empty password field")
    public void userLoginWithEmptyPasswordField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithEmptyPasswordField(new LoginPageModel().existUserLogin())
                .checkShowValidationMessageWhenLoginPasswordIsEmpty(EMPTY_INFO_MESSAGE);
    }

    @Test(description = "User can't login with invalid email")
    public void userLoginWithInvalidEmail(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().invalidEmailLogin());
        new LoginPage(driver)
                .checkShowValidationMessageWhenEmailIsInvalid(INVALID_EMAIL_INFO_MESSAGE);
    }
}
