package com.automationexercise.api.tests;

import com.automationexercise.service.BrandListService;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.conditions.Conditions.contentType;
import static com.automationexercise.conditions.Conditions.statusCode;

public class BrandListTests {
    private final String PATH_ID = "brands.id";
    private final int BRAND_ID = 8;
    private final String PATH_BRAND = "brands.brand";
    private final String BRAND = "H&M";


    @Test
    public void verifyBrandsList() throws IOException {
        new BrandListService().sendGetBrandListRequest()
                .shouldHave(statusCode(200))
                .shouldHave(contentType("text/html"));
    }

    @Test
    public void checkHtmlResponseContainsBrandId() throws IOException {
        new BrandListService()
                .sendGetBrandListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_ID, BRAND_ID);
    }

    @Test
    public void checkHtmlResponseContainsBrand() throws IOException {
        new BrandListService()
                .sendGetBrandListRequest().shouldHave(statusCode(200))
                .checkHtmlResponseContainsValueInTheList(PATH_BRAND, BRAND);
    }



}
