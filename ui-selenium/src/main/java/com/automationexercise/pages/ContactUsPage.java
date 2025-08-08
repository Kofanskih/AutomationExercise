package com.automationexercise.pages;

import com.automationexercise.pageModels.ContactUsPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactUsPage extends BasePage{
    private final By NAME_FIELD = By.cssSelector("[data-qa=\"name\"]");
    private final By EMAIL_FIELD = By.cssSelector("[data-qa=\"email\"]");
    private final By SUBJECT_FIELD = By.cssSelector("[data-qa=\"subject\"]");
    private final By MESSAGE_FIELD = By.cssSelector("[data-qa=\"message\"]");
    private final By SUBMIT_BUTTON = By.cssSelector("[data-qa=\"submit-button\"]");
    private final By ALERT_SUCCESS = By.cssSelector("[class=\"status alert alert-success\"]");
    private final By HOME_BUTTON = By.cssSelector("[class=\"fa fa-angle-double-left\"]");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement nameInput() {
        return driver.findElement(NAME_FIELD);
    }

    private WebElement emailInput() {
        return driver.findElement(EMAIL_FIELD);
    }

    private WebElement subjectInput() {
        return driver.findElement(SUBJECT_FIELD);
    }

    private WebElement messageInput() {
        return driver.findElement(MESSAGE_FIELD);
    }

    private WebElement submitButton() {
        return driver.findElement(SUBMIT_BUTTON);
    }

    public ContactUsPage fillMessageForm(ContactUsPageModel contactUsPageModel){
        nameInput().sendKeys(contactUsPageModel.getUserName());
        emailInput().sendKeys(contactUsPageModel.getUserEmailAddress());
        subjectInput().sendKeys(contactUsPageModel.getUserSubject());
        messageInput().sendKeys(contactUsPageModel.getUserMessage());
        submitButton().click();
        return this;
    }

    public ContactUsPage clickOKButton() {
        driver.switchTo().alert().accept();
        return this;
    }

    public void checkMessageWasSent(String title) {
        String actualText = waitUntilVisible(ALERT_SUCCESS).getText();
        assertEquals(actualText, title);
    }

    public ContactUsPage clickCancelButton(){
        driver.switchTo().alert().dismiss();
        return this;
    }

    public void checkHomeButtonNotAppear() {
        List<WebElement> elements = driver.findElements(HOME_BUTTON);
        assertTrue(elements.isEmpty(), "Button HOME is displayed");
    }

    public MainPage clickHomeButton(){
        waitUntilClickable(HOME_BUTTON).click();
        return new MainPage(driver);
    }
}
