package com.automationexercise.conditions;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Getter
public class AssertableResponse {
    private Response response;

    @Step("Api response shouldHave {condition}")
    public AssertableResponse shouldHave(Condition condition){
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    @Step
    public AssertableResponse shouldHave(Condition... condition){
        for (Condition cond : condition) {
            cond.check(response);
        }
        return this;
    }

    public <T> void checkHtmlResponseContainsValue(String jsonPathExpr, T expectedValue) {
        String html = response.getBody().asString();
        Document doc = Jsoup.parse(html);
        String jsonText = doc.body().wholeText();

        JsonPath jsonPath = new JsonPath(jsonText);
        List<T> values = jsonPath.getList(jsonPathExpr);

        Assert.assertTrue(values.contains(expectedValue),
                "Value '" + expectedValue + "' was not found in the list: " + values);
    }

}
