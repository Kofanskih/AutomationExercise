package com.automationexercise.pageModels;

import lombok.Data;

@Data
public class ContactUsPageModel {
    private String userName;
    private String userEmailAddress;
    private String userSubject;
    private String userMessage;

    public ContactUsPageModel messageForm(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "brbrb@brbr.com";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }

    public ContactUsPageModel messageFormInvalidEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "brbrbbrbr.com";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }

    public ContactUsPageModel messageFormEmptyEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "";
        this.userSubject = "Message";
        this.userMessage = "Message Message Message Message Message Message Message Message";
        return this;
    }
}
