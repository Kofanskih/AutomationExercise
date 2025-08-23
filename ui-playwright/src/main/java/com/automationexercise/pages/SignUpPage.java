package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class SignUpPage extends BasePage{
    private final Locator FEMALE_RADIOBUTTON = page.locator("[id=\"id_gender2\"]");
    private final Locator DAYS_DROPDOWN = page.locator("[id=\"days\"]");
    private final Locator MONTHS_DROPDOWN = page.locator("[id=\"months\"]");
    private final Locator YEARS_DROPDOWN = page.locator("[id=\"years\"]");
    private final Locator NEWSLETTER_CHECKBOX = page.locator("[id=\"newsletter\"]");
    private final Locator SPECIAL_OFFER_CHECKBOX = page.locator("[id=\"optin\"]");
    private final Locator PASSWORD_FIELD = page.locator("[id=\"password\"]");
    private final Locator FIRST_NAME_FIELD = page.locator("[id=\"first_name\"]");
    private final Locator LAST_NAME_FIELD = page.locator("[id=\"last_name\"]");
    private final Locator COMPANY_FIELD = page.locator("[id=\"company\"]");
    private final Locator ADDRESS_FIELD = page.locator("[id=\"address1\"]");
    private final Locator ADDRESS2_FIELD = page.locator("[id=\"address2\"]");
    private final Locator STATE_FIELD = page.locator("[id=\"state\"]");
    private final Locator CITY_FIELD = page.locator("[id=\"city\"]");
    private final Locator ZIPCODE_FIELD = page.locator("[id=\"zipcode\"]");
    private final Locator MOBILE_FIELD = page.locator("[id=\"mobile_number\"]");
    private final Locator COUNTRY_DROPDOWN = page.locator("[id=\"country\"]");
    private final Locator CREATE_ACCOUNT_BUTTON = page.locator("[data-qa=\"create-account\"]");
    private final Locator CONTINUE_BUTTON = page.locator("[data-qa=\"continue-button\"]");
    private final Locator SIGNUP_ERROR_MESSAGE = page.locator("[style=\"color: red;\"]");

    public SignUpPage(Page page) {
        super(page);
    }

    @Step("Choose female gender")
    public SignUpPage chooseGenderFemale(){
        FEMALE_RADIOBUTTON.click();
        return this;
    }

    @Step("Fill sign up form")
    public SignUpPage fillUserData(RegistrationPageModel registrationPageModel) {
        PASSWORD_FIELD.fill(registrationPageModel.getUserPassword());
        FIRST_NAME_FIELD.fill(registrationPageModel.getUserFirstName());
        LAST_NAME_FIELD.fill(registrationPageModel.getUserLastName());
        COMPANY_FIELD.fill(registrationPageModel.getUserCompany());
        ADDRESS_FIELD.fill(registrationPageModel.getUserAddress());
        ADDRESS2_FIELD.fill(registrationPageModel.getUserAddress2());
        STATE_FIELD.fill(registrationPageModel.getUserState());
        CITY_FIELD.fill(registrationPageModel.getUserCity());
        ZIPCODE_FIELD.fill(registrationPageModel.getUserZipCode());
        MOBILE_FIELD.fill(registrationPageModel.getUserMobile());
        return this;
    }

    @Step("Choose country")
    public SignUpPage chooseCountry(){
        COUNTRY_DROPDOWN.selectOption("United States");
        return this;
    }

    @Step("Fill date of birth dropdowns")
    public SignUpPage fillDateOfBirthDropdowns(){
        DAYS_DROPDOWN.selectOption("12");
        MONTHS_DROPDOWN.selectOption("12");
        YEARS_DROPDOWN.selectOption("2012");
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
        CREATE_ACCOUNT_BUTTON.scrollIntoViewIfNeeded();
        CREATE_ACCOUNT_BUTTON.click();
        return this;
    }

    @Step("Click continue account button")
    public MainPage clickContinueButton(){
        CONTINUE_BUTTON.click();
        return new MainPage(page);
    }

}
