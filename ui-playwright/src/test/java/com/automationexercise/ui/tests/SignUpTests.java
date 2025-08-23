package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("User registration")
@Story("Registration")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-002")
public class SignUpTests extends BaseTest{
    private String loggedUser = "Logged in as";
    private String signUpErrorMessage = "Email Address already exist!";

    @Test(description = "User registration")
    void userSignUp(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
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
                .checkUserLoggedInText(loggedUser);
    }

    @Test(description = "User sign up with exists data")
    void userSignUpWithExistData(){
        new MainPage(page)
                .acceptCookies();
        new HeaderPage(page)
                .clickLoginButton()
                .fillSignUpForm(new RegistrationPageModel().getExistsUserData())
                .checkSignUpErrorMessage(signUpErrorMessage);
    }
}
