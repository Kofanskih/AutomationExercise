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
}
