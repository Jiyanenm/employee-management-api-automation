package com.nkosinathi.api.tests.smoke;

import com.nkosinathi.api.base.BaseTest;
import com.nkosinathi.api.client.EmployeeClient;
import com.nkosinathi.api.context.TestContext;
import com.nkosinathi.api.models.EmployeeRequest;
import com.nkosinathi.api.steps.EmployeeSteps;
import com.nkosinathi.api.utils.EmployeeDataFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Employee Management API")
@Feature("Employee CRUD")
public class CreateEmployeeSmokeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Smoke Testing")
    @Owner("Nkosinathi Jiyane")
    @DisplayName("Verify employee can be created successfully")
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
    }
}