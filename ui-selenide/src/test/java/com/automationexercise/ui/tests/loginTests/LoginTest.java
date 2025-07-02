package com.automationexercise.ui.tests.loginTests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private String loggedUser = "Logout";
    private String errorMessage = "Your email or password is incorrect!";

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
                .checkLoginErrorMessage(errorMessage);
    }
}
