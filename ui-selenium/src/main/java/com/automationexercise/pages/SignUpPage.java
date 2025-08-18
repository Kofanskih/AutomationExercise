package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage{
    private final By FEMALE_RADIOBUTTON = By.id("id_gender2");
    private final By DAYS_DROPDOWN = By.id("days");
    private final By DAY_VALUE = By.cssSelector("#days [value='21']");
    private final By MONTHS_DROPDOWN = By.id("months");
    private final By MONTH_VALUE = By.cssSelector("#months [value='12']");
    private final By YEARS_DROPDOWN = By.id("years");
    private final By YEAR_VALUE = By.cssSelector("#years [value='2000']");
    private final By NEWSLETTER_CHECKBOX = By.id("newsletter");
    private final By SPECIAL_OFFER_CHECKBOX = By.id("optin");
    private final By PASSWORD_FIELD = By.id("password");
    private final By FIRST_NAME_FIELD = By.id("first_name");
    private final By LAST_NAME_FIELD = By.id("last_name");
    private final By COMPANY_FIELD = By.id("company");
    private final By ADDRESS_FIELD = By.id("address1");
    private final By ADDRESS2_FIELD = By.id("address2");
    private final By STATE_FIELD = By.id("state");
    private final By CITY_FIELD = By.id("city");
    private final By ZIPCODE_FIELD = By.id("zipcode");
    private final By MOBILE_FIELD = By.id("mobile_number");
    private final By COUNTRY_DROPDOWN = By.id("country");
    private final By COUNTRY_VALUE = By.cssSelector("select#country [value='United States']");
    private final By CREATE_ACCOUNT_BUTTON = By.cssSelector("[data-qa='create-account']");
    private final By CONTINUE_BUTTON = By.cssSelector("[data-qa='continue-button']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private WebElement femaleRadioButton() {
        return driver.findElement(FEMALE_RADIOBUTTON);
    }

    private WebElement daysDropdown() {
        return driver.findElement(DAYS_DROPDOWN);
    }

    private WebElement dayValue() {
        return driver.findElement(DAY_VALUE);
    }

    private WebElement monthsDropdown() {
        return driver.findElement(MONTHS_DROPDOWN);
    }

    private WebElement monthValue() {
        return driver.findElement(MONTH_VALUE);
    }

    private WebElement yearsDropdown() {
        return driver.findElement(YEARS_DROPDOWN);
    }

    private WebElement yearValue() {
        return driver.findElement(YEAR_VALUE);
    }

    private WebElement newsletterCheckbox() {
        return driver.findElement(NEWSLETTER_CHECKBOX);
    }

    private WebElement specialOfferCheckbox() {
        return driver.findElement(SPECIAL_OFFER_CHECKBOX);
    }

    private WebElement passwordField() {
        return driver.findElement(PASSWORD_FIELD);
    }

    private WebElement firstNameField() {
        return driver.findElement(FIRST_NAME_FIELD);
    }

    private WebElement lastNameField() {
        return driver.findElement(LAST_NAME_FIELD);
    }

    private WebElement companyField() {
        return driver.findElement(COMPANY_FIELD);
    }

    private WebElement addressField() {
        return driver.findElement(ADDRESS_FIELD);
    }

    private WebElement address2Field() {
        return driver.findElement(ADDRESS2_FIELD);
    }

    private WebElement stateField() {
        return driver.findElement(STATE_FIELD);
    }

    private WebElement cityField() {
        return driver.findElement(CITY_FIELD);
    }

    private WebElement zipcodeField() {
        return driver.findElement(ZIPCODE_FIELD);
    }

    private WebElement mobileField() {
        return driver.findElement(MOBILE_FIELD);
    }

    private WebElement countryDropdown() {
        return driver.findElement(COUNTRY_DROPDOWN);
    }

    private WebElement countryValue() {
        return driver.findElement(COUNTRY_VALUE);
    }

    private WebElement createAccountButton() {
        return driver.findElement(CREATE_ACCOUNT_BUTTON);
    }

    private WebElement continueButton() {
        return driver.findElement(CONTINUE_BUTTON);
    }

    @Step("Choose female gender")
    public SignUpPage chooseGenderFemale(){
        femaleRadioButton().click();
        return this;
    }

    @Step("Fill sign up form")
    public SignUpPage fillUserData(RegistrationPageModel registrationPageModel) {
        passwordField().sendKeys(registrationPageModel.getUserPassword());
        firstNameField().sendKeys(registrationPageModel.getUserFirstName());
        lastNameField().sendKeys(registrationPageModel.getUserLastName());
        companyField().sendKeys(registrationPageModel.getUserCompany());
        addressField().sendKeys(registrationPageModel.getUserAddress());
        address2Field().sendKeys(registrationPageModel.getUserAddress2());
        stateField().sendKeys(registrationPageModel.getUserState());
        cityField().sendKeys(registrationPageModel.getUserCity());
        zipcodeField().sendKeys(registrationPageModel.getUserZipode());
        mobileField().sendKeys(registrationPageModel.getUserMobile());
        return this;
    }

    @Step("Choose country")
    public SignUpPage chooseCountry(){
        countryDropdown().click();
        countryValue().click();
        return this;
    }

    @Step("Fill date of birth dropdowns")
    public SignUpPage fillDateOfBirthDropdowns(){
        daysDropdown().click();
        dayValue().click();
        monthsDropdown().click();
        monthValue().click();
        yearsDropdown().click();
        yearValue().click();
        return this;
    }

    @Step("Mark newsletter checkbox")
    public SignUpPage markNewsletterCheckbox(){
        newsletterCheckbox().click();
        return this;
    }

    @Step("Mark special offer checkbox")
    public SignUpPage markSpecialOfferCheckbox(){
        specialOfferCheckbox().click();
        return this;
    }

    @Step("Click create account button")
    public SignUpPage clickCreateAccountButton() {
        WebElement button = createAccountButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        return this;
    }

    @Step("Click continue account button")
    public MainPage clickContinueButton(){
        continueButton().click();
        return new MainPage(driver);
    }
}
