package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
@Story("User logs in with different credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-001")
public class LoginTest {
    private String loggedUser = "Logout";
    private String loginErrorMessage = "Your email or password is incorrect!";
    private String emptyInformationMessage = "Заполните это поле.";
    private String invalidEmailInformationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"kofanskih08gmail.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "User can login with correct credentials")
    void userLogin(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin())
                .checkUserLoggedIn(loggedUser);
    }

    @Test(description = "User can't login with incorrect credentials")
    void userIncorrectLogin(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().incorrectDataLogin())
                .checkLoginErrorMessage(loginErrorMessage);
    }

    @Test(description = "User can't login with empty email field")
    void userLoginWithEmptyEmailField() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithEmptyEmailField(new LoginPageModel().myLogin())
                .checkShowValidationMessageWhenLoginEmailIsEmpty(emptyInformationMessage);
    }

    @Test(description = "User can't login with empty password field")
    void userLoginWithEmptyPasswordField() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithEmptyPasswordField(new LoginPageModel().myLogin())
                .checkShowValidationMessageWhenPasswordIsEmpty(emptyInformationMessage);
    }

    @Test(description = "User can't login with invalid email")
    void userLoginWithInvalidEmail() {
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillLoginFormWithInvalidEmail(new LoginPageModel().invalidEmailLogin())
                .checkShowValidationMessageWhenLoginEmailIsInvalid(invalidEmailInformationMessage);
    }

}
