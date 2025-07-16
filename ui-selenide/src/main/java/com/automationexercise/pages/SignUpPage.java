package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage extends BasePage{
    private final SelenideElement FEMALE_RADIOBUTTON = $("[id=\"id_gender2\"]");
    private final SelenideElement DAYS_DROPDOWN = $("[id=\"days\"]");
    private final SelenideElement DAY_VALUE = $("[id=\"days\"] [value=\"21\"]");
    private final SelenideElement MONTHS_DROPDOWN = $("[id=\"months\"]");
    private final SelenideElement MONTH_VALUE = $("[id=\"months\"] [value=\"12\"]");
    private final SelenideElement YEARS_DROPDOWN = $("[id=\"years\"]");
    private final SelenideElement YEAR_VALUE = $("[id=\"years\"] [value=\"2000\"]");
    private final SelenideElement NEWSLETTER_CHECKBOX = $("[id=\"newsletter\"]");
    private final SelenideElement SPECIAL_OFFER_CHECKBOX = $("[id=\"optin\"]");
    private final SelenideElement PASSWORD_FIELD = $("[id=\"password\"]");
    private final SelenideElement FIRST_NAME_FIELD = $("[id=\"first_name\"]");
    private final SelenideElement LAST_NAME_FIELD = $("[id=\"last_name\"]");
    private final SelenideElement COMPANY_FIELD = $("[id=\"company\"]");
    private final SelenideElement ADDRESS_FIELD = $("[id=\"address1\"]");
    private final SelenideElement ADDRESS2_FIELD = $("[id=\"address2\"]");
    private final SelenideElement STATE_FIELD = $("[id=\"state\"]");
    private final SelenideElement CITY_FIELD = $("[id=\"city\"]");
    private final SelenideElement ZIPCODE_FIELD = $("[id=\"zipcode\"]");
    private final SelenideElement MOBILE_FIELD = $("[id=\"mobile_number\"]");
    private final SelenideElement COUNTRY_DROPDOWN = $("[id=\"country\"]");
    private final SelenideElement COUNTRY_VALUE = $("[value=\"United States\"]");
    private final SelenideElement CREATE_ACCOUNT_BUTTON = $("[data-qa=\"create-account\"]");
    private final SelenideElement CONTINUE_BUTTON = $("[data-qa=\"continue-button\"]");
    private final SelenideElement SIGNUP_ERROR_MESSAGE = $("[style=\"color: red;\"]");

    @Step("Choose female gender")
    public SignUpPage chooseGenderFemale(){
        FEMALE_RADIOBUTTON.click();
        return this;
    }

    @Step("Fill sugn up form")
    public SignUpPage fillUserData(RegistrationPageModel registrationPageModel) {
        PASSWORD_FIELD.setValue(registrationPageModel.getUserPassword());
        FIRST_NAME_FIELD.setValue(registrationPageModel.getUserFirstName());
        LAST_NAME_FIELD.setValue(registrationPageModel.getUserLastName());
        COMPANY_FIELD.setValue(registrationPageModel.getUserCompany());
        ADDRESS_FIELD.setValue(registrationPageModel.getUserAddress());
        ADDRESS2_FIELD.setValue(registrationPageModel.getUserAddress2());
        STATE_FIELD.setValue(registrationPageModel.getUserState());
        CITY_FIELD.setValue(registrationPageModel.getUserCity());
        ZIPCODE_FIELD.setValue(registrationPageModel.getUserZipode());
        MOBILE_FIELD.setValue(registrationPageModel.getUserMobile());
        return this;
    }

    @Step("Choose country")
    public SignUpPage chooseCountry(){
        COUNTRY_DROPDOWN.click();
        COUNTRY_VALUE.click();
        return this;
    }

    @Step("Fill date of birth dropdowns")
    public SignUpPage fillDateOfBirthDropdowns(){
        DAYS_DROPDOWN.click();
        DAY_VALUE.click();
        MONTHS_DROPDOWN.click();
        MONTH_VALUE.click();
        YEARS_DROPDOWN.click();
        YEAR_VALUE.click();
        return this;
    }

    @Step("Mark newsletter checkbox")
    public SignUpPage markNewsletterCheckbox(){
        NEWSLETTER_CHECKBOX.click();
        return this;
    }

    @Step("Mark special offer checkbox")
    public SignUpPage markSpecialOfferCheckbox(){
        SPECIAL_OFFER_CHECKBOX.click();
        return this;
    }

    @Step("Click create account button")
    public SignUpPage clickCreateAccountButton() {
        CREATE_ACCOUNT_BUTTON.scrollTo().click();
        return this;
    }

    @Step("Click continue account button")
    public MainPage clickContinueButton(){
        CONTINUE_BUTTON.click();
        return new MainPage();
    }

    @Step("Check Sign up error message")
    public void checkSignUpErrorMessage(String signUpErrorMessage){
        SIGNUP_ERROR_MESSAGE.shouldHave(Condition.exactTextCaseSensitive(signUpErrorMessage));
    }

}
