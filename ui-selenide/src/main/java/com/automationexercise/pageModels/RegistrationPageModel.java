package com.automationexercise.pageModels;

import lombok.Data;
import net.datafaker.Faker;

import java.util.Locale;

@Data
public class RegistrationPageModel {

    private Faker user = new Faker();
    private String userName;
    private String userEmailAddress;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userCompany;
    private String userAddress;
    private String userAddress2;
    private String userState;
    private String userCity;
    private String userZipode;
    private String userMobile;


    public RegistrationPageModel getRandomRegistrationUserData(){
        this.userName = user.name().firstName();
        this.userEmailAddress = user.internet().emailAddress();
        this.userPassword = user.word().adjective().toLowerCase() + Math.random() + user.word().noun().toUpperCase() + Math.random();
        this.userFirstName = user.name().firstName();
        this.userLastName = user.name().lastName();
        this.userCompany = user.company().name();
        this.userAddress = user.address().streetName() + " " + user.address().buildingNumber();
        this.userAddress2 = user.address().secondaryAddress();
        this.userState = user.address().state();
        this.userCity = user.address().city();
        this.userZipode = user.address().zipCode();
        this.userMobile = user.phoneNumber().cellPhone();
        return this;
    }

    public RegistrationPageModel getExistsUserData(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "kofanskih08@gmail.com";
        return this;
    }

    public RegistrationPageModel getInvalidEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "kofanskih08gmail.com";
        return this;
    }

    public RegistrationPageModel getSubscribeEmail(){
        this.userEmailAddress = user.internet().emailAddress();
        return this;
    }

    public RegistrationPageModel getInvalidSubscribeEmail(){
        this.userEmailAddress = "kofanskih08gmail.com";
        return this;
    }

}
