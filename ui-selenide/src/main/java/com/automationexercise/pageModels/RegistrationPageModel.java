package com.automationexercise.pageModels;

import io.qameta.allure.Step;
import lombok.Data;
import net.datafaker.Faker;

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
    private String userZipCode;
    private String userMobile;

    @Step("Use random user registration data")
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
        this.userZipCode = user.address().zipCode();
        this.userMobile = user.phoneNumber().cellPhone();
        return this;
    }

    @Step("Use user registration data for deleting")
    public RegistrationPageModel getRegistrationUserDataForDeleting(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "deletingTest@gmail.com";
        this.userPassword = "12345678";
        this.userFirstName = "Anastasiia";
        this.userLastName = "Bu";
        this.userCompany = "Company";
        this.userAddress = "Address one";
        this.userAddress2 = "Address two";
        this.userState = "State";
        this.userCity = "City";
        this.userZipCode = "12345";
        this.userMobile = "1234567890";
        return this;
    }

    @Step("Use user data for deleting")
    public RegistrationPageModel getExistsUserData(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "1test1test@test.com";
        return this;
    }

    @Step("Use user data with invalid email")
    public RegistrationPageModel getInvalidEmail(){
        this.userName = "Anastasiia";
        this.userEmailAddress = "1test1testtest.com";
        return this;
    }

    @Step("Use user data with subscribe email")
    public RegistrationPageModel getSubscribeEmail(){
        this.userEmailAddress = user.internet().emailAddress();
        return this;
    }

    @Step("Use user data with invalid subscribe email")
    public RegistrationPageModel getInvalidSubscribeEmail(){
        this.userEmailAddress = "test.com";
        return this;
    }
}
