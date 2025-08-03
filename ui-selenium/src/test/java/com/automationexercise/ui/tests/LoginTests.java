package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String EMPTY_INFO_MESSAGE = "Заполните это поле.";

    @Test
    public void userLoggedIn(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillLoginFormWithExistsUser(new LoginPageModel().existUserLogin())
                .checkUserLoggedIn(USER_LOGGED_IN_TEXT);
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

}
