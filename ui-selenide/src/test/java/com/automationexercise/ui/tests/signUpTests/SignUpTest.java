package com.automationexercise.ui.tests.signUpTests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.ui.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private String loggedUser = "Logout";
    private String signUpErrorMessage = "Email Address already exist!";
    private String emptyInformationMessage = "Заполните это поле.";
    private String invalidEmailInformationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"kofanskih08gmail.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
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

    @Test
    void userSignUpWithExistData(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithExistsUser(new RegistrationPageModel().getExistsUserData())
                .checkSignUpErrorMessage(signUpErrorMessage);

    }

    @Test
    void userSignUpWithEmptySignUpNameField(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithEmptyNameField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpNameIsEmpty(emptyInformationMessage);

    }

    @Test
    void userSignUpWithEmptySignUpEmailField(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithEmptyEmailField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpEmailIsEmpty(emptyInformationMessage);

    }

    @Test
    void userSignUpWithInvalidEmail(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithInvalidEmail(new RegistrationPageModel().getInvalidEmail())
                .checkShowValidationMessageWhenSignUpEmailIsInvalid(invalidEmailInformationMessage);

    }
}
