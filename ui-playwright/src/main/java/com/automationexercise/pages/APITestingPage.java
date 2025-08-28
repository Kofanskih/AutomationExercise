package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.testng.Assert.*;

public class APITestingPage extends BasePage{
    private final Locator CENTER_TEXT_TITLE = page.locator(".title.text-center");
    private final Locator LIST = page.locator("a[href='#collapse1']");
    private final Locator EXPANDED_BLOCK = page.locator("div[id='collapse1'] ul[class='list-group']");
    private final Locator COLLAPSED_BLOCK = page.locator("div#collapse1.panel-collapse.collapse");

    public APITestingPage(Page page) {
        super(page);
    }

    @Step("Check correct title on the API Testing page")
    public void checkTitleOnTheAPITestingPage(String title){
        String actualText = CENTER_TEXT_TITLE.innerText();
        assertEquals(actualText, title);
    }

    @Step("Expand the collapsed list")
    public APITestingPage expandCollapsedList(){
        LIST.click();
        return this;
    }

    @Step("Check the list is expanded")
    public void checkTheListIsExpanded(){
        assertTrue(EXPANDED_BLOCK.isVisible(), "Block should be expanded but is not visible");
    }

    @Step("Collapse the expanded list")
    public APITestingPage collapseExpandedList(){
        EXPANDED_BLOCK.isVisible();
        LIST.click();
        return this;
    }

    @Step("Check the list is collapsed")
    public void checkTheListIsCollapsed(){
        assertFalse(COLLAPSED_BLOCK.isVisible(), "Block should be collapsed but is visible");
    }
}
