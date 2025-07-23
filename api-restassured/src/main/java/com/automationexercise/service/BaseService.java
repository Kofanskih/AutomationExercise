package com.automationexercise.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.OwnerReadMainUrl.readMainUrl;

public class BaseService {
    protected RequestSpecification baseConfiguration(){
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(readMainUrl())
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;
    }
}
