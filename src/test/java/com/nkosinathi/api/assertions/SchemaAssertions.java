package com.nkosinathi.api.assertions;

import com.nkosinathi.api.ai.model.FailureContext;
import com.nkosinathi.api.ai.service.AIService;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaAssertions {

    private static final AIService aiService =
            new AIService();

    public static void verifySchema(
            String schema,
            String response
    ) {

        try {

            assertThat(
                    response,
                    matchesJsonSchemaInClasspath(schema)
            );

        } catch (AssertionError ex) {

            FailureContext context =
                    new FailureContext();

            context.setResponseBody(response);
            context.setAssertionMessage(ex.getMessage());

            aiService.analyze(context);

            throw ex;
        }

    }

}