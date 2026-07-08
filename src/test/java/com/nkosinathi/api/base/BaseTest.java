package com.nkosinathi.api.base;

import com.nkosinathi.api.ai.model.FailureContext;
import com.nkosinathi.api.ai.service.AIService;
import com.nkosinathi.api.config.RequestSpecificationFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class BaseTest {

    @BeforeAll
    static void setUp() {

        RestAssured.requestSpecification =
                RequestSpecificationFactory.getRequestSpecification();

    }
    protected void validateSchema(String schemaPath, String responseBody) {

        InputStream schema = getClass()
                .getClassLoader()
                .getResourceAsStream(schemaPath);

        if (schema == null) {
            throw new RuntimeException("Schema NOT FOUND: " + schemaPath);
        }

        assertThat(responseBody, matchesJsonSchema(schema));
    }
    protected void analyzeFailure(
            Response response,
            int expectedStatus,
            String endpoint,
            String method,
            String requestBody
    ) {
        FailureContext context = new FailureContext();
        context.setEndpoint(endpoint);
        context.setHttpMethod(method);
        context.setExpectedStatus(expectedStatus);
        context.setActualStatus(response.statusCode());
        context.setRequestBody(requestBody);
        context.setResponseBody(response.asPrettyString());

        new AIService().analyze(context);
    }
    protected void verifyStatus(
            Response response,
            int expectedStatus,
            String endpoint,
            String method,
            Object requestBody
    ) {

        if (response.statusCode() != expectedStatus) {

            FailureContext context = new FailureContext();

            context.setEndpoint(endpoint);
            context.setHttpMethod(method);
            context.setExpectedStatus(expectedStatus);
            context.setActualStatus(response.statusCode());
            context.setRequestBody(requestBody.toString());
            context.setResponseBody(response.asPrettyString());

            new AIService().analyze(context);
        }

        response.then().statusCode(expectedStatus);
    }
}