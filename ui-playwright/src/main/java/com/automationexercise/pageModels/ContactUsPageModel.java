package com.automationexercise.pageModels;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class ContactUsPageModel {
    private String userName;
    private String userEmailAddress;
    private String userSubject;
    private String userMessage;

    @Step("Use Contact us with valid message form")
    public ContactUsPageModel messageForm(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "brbrb@brbr.com";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }

    @Step("Use Contact us with invalid email message form")
    public ContactUsPageModel messageFormInvalidEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "brbrbbrbr.com";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }

    @Step("Use Contact us with empty email message form")
    public ContactUsPageModel messageFormEmptyEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }
}
