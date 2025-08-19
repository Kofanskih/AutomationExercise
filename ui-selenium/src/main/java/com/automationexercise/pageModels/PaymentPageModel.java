package com.automationexercise.pageModels;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class PaymentPageModel {
    private String nameOnCard;
    private String cardNumber;
    private String cvc;
    private String month;
    private String year;

    @Step("Use correct payment data")
    public PaymentPageModel existPaymentData(){
        this.nameOnCard = "User";
        this.cardNumber = "1234567890123456";
        this.cvc = "123";
        this.month = "01";
        this.year = "2055";
        return this;
    }
}
