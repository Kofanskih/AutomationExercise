package com.automationexercise.models.createUser;

import lombok.Data;
import net.datafaker.Faker;

import java.util.HashMap;
import java.util.Map;

@Data
public class CreateUserModel {
    private Faker user = new Faker();
    private String userName;
    private String userEmailAddress;
    private String userPassword;
    private String userTitle;
    private String userBirthDate;
    private String userBirthMonth;
    private String userBirthYear;
    private String userFirstName;
    private String userLastName;
    private String userCompany;
    private String userAddress;
    private String userAddress2;
    private String userCountry;
    private String userState;
    private String userCity;
    private String userZipcode;
    private String userMobile;


    public CreateUserModel getRandomCreateUserData(){
        this.userName = user.name().username();
        this.userEmailAddress = user.internet().emailAddress();
        this.userPassword = user.internet().password();
        this.userTitle = "Mr";
        this.userBirthDate = String.valueOf(user.number().numberBetween(1, 28));
        this.userBirthMonth = String.valueOf(user.number().numberBetween(1, 12));
        this.userBirthYear = String.valueOf(user.number().numberBetween(1970, 2000));
        this.userFirstName = user.name().firstName();
        this.userLastName = user.name().lastName();
        this.userCompany = user.company().name();
        this.userAddress = user.address().streetAddress();
        this.userAddress2 = user.address().secondaryAddress();
        this.userCountry = "Canada";
        this.userZipcode = user.address().zipCode();
        this.userState = user.address().state();
        this.userCity = user.address().city();
        this.userMobile = user.phoneNumber().cellPhone();
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", userName);
        map.put("email", userEmailAddress);
        map.put("password", userPassword);
        map.put("title", userTitle);
        map.put("birth_date", userBirthDate);
        map.put("birth_month", userBirthMonth);
        map.put("birth_year", userBirthYear);
        map.put("firstname", userFirstName);
        map.put("lastname", userLastName);
        map.put("company", userCompany);
        map.put("address1", userAddress);
        map.put("address2", userAddress2);
        map.put("country", userCountry);
        map.put("zipcode", userZipcode);
        map.put("state", userState);
        map.put("city", userCity);
        map.put("mobile_number", userMobile);
        return map;
    }

}
