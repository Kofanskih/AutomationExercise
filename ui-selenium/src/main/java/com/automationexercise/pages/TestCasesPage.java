package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class TestCasesPage extends BasePage{
    private final By CENTER_TEXT_TITLE = By.cssSelector("[class=\"title text-center\"]");
    private final By LIST = By.cssSelector("[href=\"#collapse1\"]");
    private final By EXPANDED_BLOCK = By.xpath("//div[@id=\"collapse1\"]/ul[@class=\"list-group\"]");
    private final By COLLAPSED_BLOCK = By.xpath("//div[@id=\"collapse1\"][@class=\"panel-collapse collapsing\"]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public void checkTitleOnTheTestCasesPage(String title){
        String actualText = waitUntilVisible(CENTER_TEXT_TITLE).getText();
        assertEquals(actualText, title);
    }

    public TestCasesPage expandCollapsedList(){
        waitUntilClickable(LIST).click();
        return this;
    }

    public void checkTheListIsExpanded(){
        waitUntilVisible(EXPANDED_BLOCK).isDisplayed();
    }

    public TestCasesPage collapseExpandedList(){
        waitUntilVisible(EXPANDED_BLOCK).isDisplayed();
        waitUntilClickable(LIST).click();
        return this;
    }

    public void checkTheListIsCollapsed(){
        waitUntilVisible(COLLAPSED_BLOCK).isDisplayed();
    }
}
