package com.automationexercise.ui.tests.deleteTests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends BaseTest {
    private String expectedMainURL = "https://automationexercise.com/";
    private String title = "ACCOUNT DELETED!";
    private String loginErrorMessage = "Your email or password is incorrect!";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();

        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpForm(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test
    void deleteUser(){
        new HeaderPage().clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void checkTitleAfterDeletingAccount(){
        new HeaderPage().clickDeleteAccountButton()
                .checkTitleAfterDeletingAccount(title);
    }

    @Test
    void userTryToLoginAfterDeletingAccount(){
        new HeaderPage().clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage();
        new HeaderPage().clickLoginButton()
                .fillLoginForm(new LoginPageModel().loginForDelete())
                .checkLoginErrorMessage(loginErrorMessage);
    }

}
