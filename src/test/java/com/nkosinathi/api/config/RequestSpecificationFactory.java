package com.nkosinathi.api.config;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationFactory {

    private RequestSpecificationFactory() {
    }

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()

                .setBaseUri(ConfigReader.get("base.url"))

                .setBasePath(ConfigReader.get("base.path"))

                .setContentType("application/json")

                .addFilter(new AllureRestAssured())
                
                .log(LogDetail.ALL)

                .build();
    }
}