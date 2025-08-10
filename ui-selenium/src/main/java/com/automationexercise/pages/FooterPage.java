package com.automationexercise.pages;

import com.automationexercise.pageModels.RegistrationPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

public class FooterPage extends BasePage{
    private final By SUBSCRIBE_FIELD = By.cssSelector("[id=\"susbscribe_email\"]");
    private final By SUBSCRIBE_BUTTON = By.cssSelector("[id=\"subscribe\"]");
    private final By SUCCESS_SUBSCRIBE_MESSAGE = By.xpath("//div[@class=\"alert-success alert\"]");

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserIsSubscribed(RegistrationPageModel registrationPageModel, String message){
        waitUntilClickable(SUBSCRIBE_FIELD).sendKeys(registrationPageModel.getUserEmailAddress());
        waitUntilClickable(SUBSCRIBE_BUTTON).click();
        String actualText = waitUntilVisible(SUCCESS_SUBSCRIBE_MESSAGE).getText();
        assertEquals(message, actualText);
    }

}
