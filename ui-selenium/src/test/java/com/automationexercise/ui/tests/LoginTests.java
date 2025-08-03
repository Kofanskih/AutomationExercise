package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    private final String USER_LOGGED_IN_TEXT = "Logged in as";

    @Test
    public void userLoggedIn(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithExistsUser(new LoginPageModel().existUserLogin())
                .checkUserLoggedIn(USER_LOGGED_IN_TEXT);
    }

}
