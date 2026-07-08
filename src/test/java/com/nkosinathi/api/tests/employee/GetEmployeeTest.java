package com.nkosinathi.api.tests.employee;

import com.nkosinathi.api.assertions.AIAssertions;
import com.nkosinathi.api.assertions.ResponseAssertions;
import com.nkosinathi.api.assertions.SchemaAssertions;
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
        AIAssertions.verifyStatus(response, 200);

        ResponseAssertions.verifyEmployees(response);

        SchemaAssertions.verifySchema(
                "schemas/employee-schema.json",
                response.asString()
        );
    }
}