package com.automationexercise.ui.tests.signUpTests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private String loggedUser = "Logout";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void userSignUp(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpForm(new RegistrationPageModel().getRandomRegistrationUserData())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRandomRegistrationUserData())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton()
                .checkUserLoggedIn(loggedUser);

    }
}
