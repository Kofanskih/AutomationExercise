package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.LoginPageModel;
import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Delete account")
@Feature("Account deleting")
@Story("Delete account")
@Severity(SeverityLevel.NORMAL)
@Owner("bukovtseva")
@TmsLink("TC-006")
public class DeleteTests extends BaseTest{
    private String expectedMainURL = "https://automationexercise.com/";
    private String title = "ACCOUNT DELETED!";
    private String loginErrorMessage = "Your email or password is incorrect!";

    @Test(description = "Delete user account")
    public void deleteUser(){
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickLoginLogoutButton()
                .fillSignUpForm(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton();
        new HeaderPage()
                .clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Check title after deleting account")
    void checkTitleAfterDeletingAccount(){
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickLoginLogoutButton()
                .fillSignUpForm(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton();
        new HeaderPage()
                .clickDeleteAccountButton()
                .checkTitleAfterDeletingAccount(title);
    }

    @Test(description = "Try to login with deleting account")
    void userTryToLoginAfterDeletingAccount(){
        new MainPage()
                .acceptCookies();
        new HeaderPage()
                .clickLoginLogoutButton()
                .fillSignUpForm(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRegistrationUserDataForDeleting())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton();
        new HeaderPage()
                .clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage();
        new HeaderPage()
                .clickLoginLogoutButton()
                .fillLoginForm(new LoginPageModel().loginForDelete());
        new LoginPage()
                .checkLoginErrorMessage(loginErrorMessage);
    }
}
