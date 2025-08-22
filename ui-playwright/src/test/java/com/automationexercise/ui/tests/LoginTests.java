package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private final String USER_LOGGED_IN_TEXT = "Logged in as";

    @Test(description = "User can login with correct credentials")
    public void userLogin(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().myLogin())
                .checkUserLoggedInText(USER_LOGGED_IN_TEXT);
    }

}
