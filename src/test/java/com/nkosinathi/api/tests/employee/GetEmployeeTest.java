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
public class GetEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Get Employee")
    @DisplayName("Verify employee can be retrieved by ID")
    void shouldGetEmployeeById() {

        // Arrange
        EmployeeRequest employee = EmployeeDataFactory.createValidEmployee();

        String employeeId = EmployeeSteps.createEmployee(employee);

        // Act
        Response response = EmployeeSteps.getEmployee(employeeId);

        response.prettyPrint();

        // Assert
        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/employee-schema.json"))
                .body("success", equalTo(true))
                .body("data.id", equalTo(employeeId))
                .body("data.name", equalTo(employee.getName()))
                .body("data.email", equalTo(employee.getEmail()))
                .body("data.department", equalTo(employee.getDepartment()))
                .body("data.status", equalTo(employee.getStatus()));
    }
}