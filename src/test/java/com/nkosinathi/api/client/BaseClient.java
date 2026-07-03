package com.nkosinathi.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BaseClient {

    /**
     * Standard GET request
     */
    protected Response get(String endpoint) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(endpoint);
    }

    /**
     * GET request with query parameters
     */
    protected Response get(String endpoint, String paramName, String paramValue) {
        return given()
                .spec(requestSpecification)
                .queryParam(paramName, paramValue)
                .when()
                .get(endpoint);
    }

    /**
     * POST request
     */
    protected Response post(String endpoint, Object body) {
        return given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post(endpoint);
    }

    /**
     * PUT request
     */
    protected Response put(String endpoint, Object body) {
        return given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .put(endpoint);
    }

    /**
     * DELETE request
     */
    protected Response delete(String endpoint) {
        return given()
                .spec(requestSpecification)
                .when()
                .delete(endpoint);
    }
}