package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class DeleteTests extends BaseTest{
    private String expectedMainURL = "https://automationexercise.com/";
    private String title = "ACCOUNT DELETED!";

    @Test
    public void deleteUser(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
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
        new HeaderPage(driver)
                .clickDeleteAccountButton()
                .clickContinueButtonOnTheDeletePage()
                .checkUrlOnTheMainPage(expectedMainURL);
    }

    @Test
    void checkTitleAfterDeletingAccount(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
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
        new HeaderPage(driver)
                .clickDeleteAccountButton()
                .checkTitleAfterDeletingAccount(title);
    }
}
