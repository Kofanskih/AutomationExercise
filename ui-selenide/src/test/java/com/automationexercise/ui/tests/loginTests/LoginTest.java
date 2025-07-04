package com.automationexercise.ui.tests.loginTests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private String loggedUser = "Logout";
    private String loginErrorMessage = "Your email or password is incorrect!";
    private String emptyInformationMessage = "Заполните это поле.";
    private String invalidEmailInformationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"kofanskih08gmail.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void userLogin(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin())
                .checkUserLoggedIn(loggedUser);
    }

    @Test
    void userIncorrectLogin(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().incorrectDataLogin())
                .checkLoginErrorMessage(loginErrorMessage);
    }

    @Test
    void userLoginWithEmptyEmailField() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithEmptyEmailField(new LoginPageModel().myLogin())
                .checkShowValidationMessageWhenEmailIsEmpty(emptyInformationMessage);
    }

    @Test
    void userLoginWithEmptyPasswordField() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithEmptyPasswordField(new LoginPageModel().myLogin())
                .checkShowValidationMessageWhenPasswordIsEmpty(emptyInformationMessage);
    }

    @Test
    void userLoginWithInvalidEmail() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithInvalidEmail(new LoginPageModel().invalidEmailLogin())
                .checkShowValidationMessageWhenEmailIsInvalid(invalidEmailInformationMessage);
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

}
