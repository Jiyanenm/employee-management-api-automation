package com.nkosinathi.api.assertions;

import com.nkosinathi.api.ai.model.FailureContext;
import com.nkosinathi.api.ai.service.AIService;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public final class AIAssertions {

    private static final AIService AI_SERVICE = new AIService();

    private AIAssertions() {
        // Prevent instantiation
    }

    /**
     * Full verification with endpoint details.
     */
    public static void verifyStatus(
            Response response,
            int expectedStatus,
            String endpoint,
            String method,
            Object requestBody) {

        if (response.statusCode() != expectedStatus) {

            FailureContext context = new FailureContext();

            context.setEndpoint(endpoint);
            context.setHttpMethod(method);
            context.setExpectedStatus(expectedStatus);
            context.setActualStatus(response.statusCode());

            context.setRequestBody(
                    requestBody == null ? "" : requestBody.toString());

            context.setResponseBody(response.asPrettyString());

            AI_SERVICE.analyze(context);
        }

        response.then().statusCode(expectedStatus);
    }

    /**
     * Simple status verification.
     */
    public static void verifyStatus(
            Response response,
            int expectedStatus) {

        verifyStatus(
                response,
                expectedStatus,
                "Unknown Endpoint",
                "Unknown Method",
                null
        );
    }

    /**
     * Verify any boolean field.
     */
    public static void verifySuccess(
            Response response,
            boolean expected) {

        response.then()
                .body("success",
                        equalTo(expected));
    }

    /**
     * Verify response message.
     */
    public static void verifyMessage(
            Response response,
            String expectedMessage) {

        response.then()
                .body("message",
                        equalTo(expectedMessage));
    }
    public static void verifyEmployee(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("data.id", notNullValue())
                .body("data.name", notNullValue())
                .body("data.email", notNullValue());
    }
    public static void verifyEmployeeUpdated(Response response) {

        response.then()
                .body("success", equalTo(true))
                .body("message",
                        equalTo("Employee updated successfully."));
    }

}