package com.nkosinathi.api.assertions;

import com.nkosinathi.api.client.EmployeeClient;
import com.nkosinathi.api.models.EmployeeRequest;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseAssertions {

    public static void verifyCreateEmployee(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("message",
                        equalTo("Employee created successfully."))
                .body("data", notNullValue());

    }
    public static void verifyEmployeeDeleted(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("message",
                        equalTo("Employee deleted successfully."));
    }
    public static void verifyEmployees(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("data", notNullValue());
    }
    public static void verifyEmployeeUpdated(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("message", equalTo("Employee updated successfully."))
                .body("data", notNullValue());
    }
    public static void verifyEmployeeRetrieved(
            Response response,
            EmployeeRequest expectedEmployee
    ) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("message", equalTo("Employee retrieved successfully."))
                .body("data.name", equalTo(expectedEmployee.getName()))
                .body("data.email", equalTo(expectedEmployee.getEmail()))
                .body("data.department", equalTo(expectedEmployee.getDepartment()))
                .body("data.status", equalTo(expectedEmployee.getStatus()));
    }
}