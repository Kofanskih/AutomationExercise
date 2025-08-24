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
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
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
        new HeaderPage(page)
                .clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test(description = "Check title after deleting account")
    void checkTitleAfterDeletingAccount(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
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
        new HeaderPage(page)
                .clickDeleteAccountButton()
                .checkTitleAfterDeletingAccount(title);
    }

    @Test(description = "Try to login with deleting account")
    void userTryToLoginAfterDeletingAccount(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
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
        new HeaderPage(page)
                .clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage();
        new HeaderPage(page)
                .clickLoginButton()
                .fillLoginForm(new LoginPageModel().loginForDelete());
        new LoginPage(page)
                .checkLoginErrorMessage(loginErrorMessage);
    }
}
