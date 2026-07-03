package com.nkosinathi.api.base;

import com.nkosinathi.api.config.RequestSpecificationFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setUp() {

        RestAssured.requestSpecification =
                RequestSpecificationFactory.getRequestSpecification();

    }
}