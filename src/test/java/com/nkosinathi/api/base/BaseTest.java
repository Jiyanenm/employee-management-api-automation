package com.nkosinathi.api.base;

import com.nkosinathi.api.config.RequestSpecificationFactory;
import io.restassured.RestAssured;
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
}