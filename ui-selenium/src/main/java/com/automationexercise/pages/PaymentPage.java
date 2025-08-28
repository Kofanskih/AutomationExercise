package com.automationexercise.pages;

import com.automationexercise.pageModels.PaymentPageModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

public class PaymentPage extends BasePage{
    private final By NAME_ON_CARD_FIELD = By.cssSelector("[name=\"name_on_card\"]");
    private final By CARD_NUMBER_FIELD = By.cssSelector("[data-qa=\"card-number\"]");
    private final By CVC_FIELD = By.cssSelector("[name=\"cvc\"]");
    private final By EXPIRY_MONTH_FIELD = By.cssSelector("[name=\"expiry_month\"]");
    private final By EXPIRY_YEAR_FIELD = By.cssSelector("[data-qa=\"expiry-year\"]");
    private final By PAY_AND_CONFIRM_BUTTON = By.cssSelector("[data-qa=\"pay-button\"]");
    private final By TITLE = By.cssSelector("[data-qa=\"order-placed\"]");
    private final By CONTINUE_BUTTON = By.cssSelector("[data-qa=\"continue-button\"]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check URL on the Payment page")
    public void checkUrlOnThePaymentPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    private WebElement nameInput() {
        return driver.findElement(NAME_ON_CARD_FIELD);
    }

    private WebElement cardNumberInput() {
        return driver.findElement(CARD_NUMBER_FIELD);
    }

    private WebElement cvcInput() {
        return driver.findElement(CVC_FIELD);
    }

    private WebElement monthInput() {
        return driver.findElement(EXPIRY_MONTH_FIELD);
    }

    private WebElement yearInput() {
        return driver.findElement(EXPIRY_YEAR_FIELD);
    }

    private WebElement payConfirmButton() {
        return driver.findElement(PAY_AND_CONFIRM_BUTTON);
    }

    @Step("Fill payment form")
    public PaymentPage fillPaymentForm(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    @Step("Check place order title")
    public void checkPlaceOrderTitle(String title) {
        String actualText = waitUntilVisible(TITLE).getText();
        assertEquals(actualText, title);
    }

    @Step("Fill payment form with empty name on card")
    public PaymentPage fillPaymentFormWithEmptyName(PaymentPageModel paymentPageModel){
        nameInput().clear();
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    @Step("Check validation message if name on card is empty")
    public void checkShowValidationMessageWhenNameOnCardIsEmpty(String expectedMessage) {
        WebElement nameField = nameInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", nameField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty card number")
    public PaymentPage fillPaymentFormWithEmptyCardNumber(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().clear();
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    @Step("Check validation message if card name is empty")
    public void checkShowValidationMessageWhenCardNumberIsEmpty(String expectedMessage) {
        WebElement cardNumberField = cardNumberInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", cardNumberField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty cvc")
    public PaymentPage fillPaymentFormWithEmptyCVC(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().clear();
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    @Step("Check validation message if cvc is empty")
    public void checkShowValidationMessageWhenCVCIsEmpty(String expectedMessage) {
        WebElement cvcField = cvcInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", cvcField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty month")
    public PaymentPage fillPaymentFormWithEmptyMonth(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().clear();
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    @Step("Check validation message if month is empty")
    public void checkShowValidationMessageWhenMonthIsEmpty(String expectedMessage) {
        WebElement monthField = monthInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", monthField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Fill payment form with empty year")
    public PaymentPage fillPaymentFormWithEmptyYear(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().clear();
        payConfirmButton().click();

        return this;
    }

    @Step("Check validation message if year is empty")
    public void checkShowValidationMessageWhenYearIsEmpty(String expectedMessage) {
        WebElement yearField = yearInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", yearField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }

    @Step("Click continue button")
    public MainPage clickContinueButton(){
        waitUntilClickable(CONTINUE_BUTTON).click();

        return new MainPage(driver);
    }
}
