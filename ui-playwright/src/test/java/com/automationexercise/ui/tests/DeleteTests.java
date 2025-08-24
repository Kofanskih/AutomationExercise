package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class DeleteTests extends BaseTest{
    private String expectedMainURL = "https://automationexercise.com/";
    private String title = "ACCOUNT DELETED!";

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
}
