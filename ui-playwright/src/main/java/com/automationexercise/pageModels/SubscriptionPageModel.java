package com.automationexercise.pageModels;

import io.qameta.allure.Step;
import lombok.Data;
import net.datafaker.Faker;

@Data
public class SubscriptionPageModel {
    private Faker user = new Faker();
    private String userEmailAddress;

    @Step("Use user data with subscribe email")
    public SubscriptionPageModel getSubscribeEmail(){
        this.userEmailAddress = user.internet().emailAddress();
        return this;
    }
}
