package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.MainPage;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest{
    private final String USER_LOGGED_IN_TEXT = "Logged in as";
    private final String SIGN_UP_ERROR_MESSAGE = "Email Address already exist!";
    private final String EMPTY_INFO_MESSAGE = "Заполните это поле.";
    private final String INVALID_EMAIL_INFO_MESSAGE  = "Адрес электронной почты должен содержать символ \"@\". В адресе \"1test1testtest.com\" отсутствует символ \"@\".";


    @Test
    void userSignUp(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillSignUpForm(new RegistrationPageModel().getRandomRegistrationUserData())
                .chooseGenderFemale()
                .fillUserData(new RegistrationPageModel().getRandomRegistrationUserData())
                .chooseCountry()
                .fillDateOfBirthDropdowns()
                .markNewsletterCheckbox()
                .markSpecialOfferCheckbox()
                .clickCreateAccountButton()
                .clickContinueButton()
                .checkUserLoggedIn(USER_LOGGED_IN_TEXT);

    }

    @Test
    void userSignUpWithExistData(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillSignUpFormWithExistsUser(new RegistrationPageModel().getExistsUserData());
        new LoginPage(driver)
                .checkSignUpErrorMessage(SIGN_UP_ERROR_MESSAGE);

    }

    @Test
    void userSignUpWithEmptySignUpNameField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillSignUpFormWithEmptyNameField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpNameIsEmpty(EMPTY_INFO_MESSAGE);

    }

    @Test
    void userSignUpWithEmptySignUpEmailField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillSignUpFormWithEmptyEmailField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpEmailIsEmpty(EMPTY_INFO_MESSAGE);

    }

    @Test
    void userSignUpWithInvalidSignUpEmailField(){
        new MainPage(driver)
                .acceptCookies();
        new HeaderPage(driver)
                .clickLoginLogoutButton()
                .fillSignUpFormWithInvalidEmail(new RegistrationPageModel().getInvalidEmail())
                .checkShowValidationMessageWhenSignUpEmailIsInvalid(INVALID_EMAIL_INFO_MESSAGE);

    }
}
