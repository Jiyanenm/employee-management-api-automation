package com.nkosinathi.api.tests.employee;

import com.nkosinathi.api.base.BaseTest;
import com.nkosinathi.api.models.EmployeeRequest;
import com.nkosinathi.api.steps.EmployeeSteps;
import com.nkosinathi.api.utils.EmployeeDataFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("Employee Management API")
@Feature("Employee CRUD")
@Owner("Nkosinathi Jiyane")
public class CreateEmployeeTest extends BaseTest {

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a new employee can be created successfully.")
    @DisplayName("Create Employee Successfully")
    void shouldCreateEmployeeSuccessfully() {

        // Arrange
        EmployeeRequest employee =
                EmployeeDataFactory.createValidEmployee();

        // Act
        Response response =
                EmployeeSteps.createEmployeeResponse(employee);

        response.prettyPrint();

        // Assert
        response.then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("message", equalTo("Employee created successfully."))
                .body("data", notNullValue());
        validateSchema(
                "schemas/create-employee-schema.json",
                response.asString()
        );
    }
}