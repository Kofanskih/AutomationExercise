package com.automationexercise.ui.tests.loginSignupTests;

import com.automationexercise.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUp();
    }
}
