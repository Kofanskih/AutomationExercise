package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class APITestingPage extends BasePage{
    private final By CENTER_TEXT_TITLE = By.cssSelector("[class=\"title text-center\"]");
    private final By LIST = By.cssSelector("[href=\"#collapse1\"]");
    private final By EXPANDED_BLOCK = By.xpath("//div[@id=\"collapse1\"]/ul[@class=\"list-group\"]");
    private final By COLLAPSED_BLOCK = By.xpath("//div[@id=\"collapse1\"][@class=\"panel-collapse collapsing\"]");

    public APITestingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check correct title on the API Testing page")
    public void checkTitleOnTheAPITestingPage(String title){
        String actualText = waitUntilVisible(CENTER_TEXT_TITLE).getText();
        assertEquals(actualText, title);
    }

    @Step("Expand the collapsed list")
    public APITestingPage expandCollapsedList(){
        waitUntilClickable(LIST).click();
        return this;
    }

    @Step("Check the list is expanded")
    public void checkTheListIsExpanded(){
        waitUntilVisible(EXPANDED_BLOCK).isDisplayed();
    }

    @Step("Collapse the expanded list")
    public APITestingPage collapseExpandedList(){
        waitUntilVisible(EXPANDED_BLOCK).isDisplayed();
        waitUntilClickable(LIST).click();
        return this;
    }

    @Step("Check the list is collapsed")
    public void checkTheListIsCollapsed(){
        waitUntilVisible(COLLAPSED_BLOCK).isDisplayed();
    }
}
