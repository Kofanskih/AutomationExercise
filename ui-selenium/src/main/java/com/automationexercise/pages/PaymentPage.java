package com.automationexercise.pages;

import com.automationexercise.pageModels.PaymentPageModel;
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

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

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

    private WebElement placeOrderTitle() {
        return driver.findElement(TITLE);
    }

    public PaymentPage fillPaymentForm(PaymentPageModel paymentPageModel){
        nameInput().sendKeys(paymentPageModel.getNameOnCard());
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }

    public void checkPlaceOrderTitle(String title) {
        String actualText = placeOrderTitle().getText();
        assertEquals(actualText, title);
    }

    public PaymentPage fillPaymentFormWithEmptyName(PaymentPageModel paymentPageModel){
        nameInput().clear();
        cardNumberInput().sendKeys(paymentPageModel.getCardNumber());
        cvcInput().sendKeys(paymentPageModel.getCvc());
        monthInput().sendKeys(paymentPageModel.getMonth());
        yearInput().sendKeys(paymentPageModel.getYear());
        payConfirmButton().click();

        return this;
    }
    public void checkShowValidationMessageWhenNameOnCardIsEmpty(String expectedMessage) {
        WebElement nameField = nameInput();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String actualMessage = (String) jsExecutor.executeScript(
                "return arguments[0].validationMessage;", nameField);
        AssertJUnit.assertEquals(expectedMessage, actualMessage);
    }
}
