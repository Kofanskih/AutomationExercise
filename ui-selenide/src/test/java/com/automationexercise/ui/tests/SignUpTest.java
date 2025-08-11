package com.automationexercise.ui.tests;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HeaderPage;
import com.automationexercise.pages.MainPage;
import com.automationexercise.utils.ConfigurateBrowserSettings;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Epic("Authentication")
@Feature("User registration")
@Story("Registration")
@Severity(SeverityLevel.CRITICAL)
@Owner("bukovtseva")
@TmsLink("TC-002")
public class SignUpTest {
    private String loggedUser = "Logout";
    private String signUpErrorMessage = "Email Address already exist!";
    private String emptyInformationMessage = "Заполните это поле.";
    private String invalidEmailInformationMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"1test1testtest.com\" отсутствует символ \"@\".";

    @BeforeMethod
    void preconditionMethod(){
        new ConfigurateBrowserSettings().setUp();
        new BasePage().open();
    }

    @AfterMethod
    void postconditionMethod(){
        new BasePage().close();
    }

    @Test(description = "User registration")
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

    @Test(description = "User sign up with exists data")
    void userSignUpWithExistData(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithExistsUser(new RegistrationPageModel().getExistsUserData())
                .checkSignUpErrorMessage(signUpErrorMessage);

    }

    @Test(description = "User sign up with empty name field")
    void userSignUpWithEmptySignUpNameField(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithEmptyNameField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpNameIsEmpty(emptyInformationMessage);

    }

    @Test(description = "User sign up with empty email field")
    void userSignUpWithEmptySignUpEmailField(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithEmptyEmailField(new RegistrationPageModel().getRandomRegistrationUserData())
                .checkShowValidationMessageWhenSignUpEmailIsEmpty(emptyInformationMessage);

    }

    @Test(description = "User sign up with invalid email")
    void userSignUpWithInvalidEmail(){
        new MainPage().acceptCookies();
        new HeaderPage()
                .clickLoginButton()
                .fillSignUpFormWithInvalidEmail(new RegistrationPageModel().getInvalidEmail())
                .checkShowValidationMessageWhenSignUpEmailIsInvalid(invalidEmailInformationMessage);

    }
}
