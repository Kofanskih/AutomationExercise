package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    private final By ACCEPT_COOKIES_BUTTON = By.className("fc-button-label");
    private final By LOGGED_IN_TEXT = By.xpath("//a[contains(text(), 'Logged in as')]");
    private final By ADD_ITEM_TO_CART = By.cssSelector("[data-product-id=\"3\"]");
    private final By ADDED_MODAL_WINDOW_TEXT = By.xpath("//div[@class='modal-body']//p[@class='text-center']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage acceptCookies() {
        waitUntilClickable(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

    public String isLoggedInText() {
        return waitUntilVisible(LOGGED_IN_TEXT).getText();
    }

    public void checkUserLoggedInText(String expectedSubstring){
        String actualText = isLoggedInText();
        assertTrue(actualText.contains(expectedSubstring));
    }

    public void checkUrlOnTheMainPage(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    public MainPage addItemToTheCartOnTheMainPage() {
        waitUntilClickable(ADD_ITEM_TO_CART).click();
        return this;
    }

    private WebElement addedModalWindow() {
        return waitUntilVisible(ADDED_MODAL_WINDOW_TEXT);
    }

    public void checkProductAddedMessage(String infoModalMessage) {
        String actualText = addedModalWindow().getText();
        assertEquals(actualText, infoModalMessage);
    }
}
