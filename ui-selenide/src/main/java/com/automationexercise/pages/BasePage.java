package com.automationexercise.pages;

import com.codeborne.selenide.Selenide;
import static com.automationexercise.utils.ReadUrl.readMainUrl;

public class BasePage {

    public BasePage open(){
        Selenide.open(readMainUrl());
        return new BasePage();
    }

    public void close(){
        Selenide.closeWebDriver();
    }
}
