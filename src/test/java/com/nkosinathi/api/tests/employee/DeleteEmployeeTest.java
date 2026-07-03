package com.nkosinathi.api.tests.employee;

import com.nkosinathi.api.base.BaseTest;
import com.nkosinathi.api.models.EmployeeRequest;
import com.nkosinathi.api.steps.EmployeeSteps;
import com.nkosinathi.api.utils.EmployeeDataFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("Employee Management API")
@Feature("Employee CRUD")
@Owner("Nkosinathi Jiyane")
public class DeleteEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Employee")
    @DisplayName("Verify employee can be deleted successfully")
    void shouldDeleteEmployeeSuccessfully() {

        // Arrange
        EmployeeRequest employee = EmployeeDataFactory.createValidEmployee();
        String employeeId = EmployeeSteps.createEmployee(employee);

        // Act
        Response deleteResponse = EmployeeSteps.deleteEmployee(employeeId);

        // Assert
        deleteResponse.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("message", equalTo("Employee deleted successfully."));

        validateSchema(
                "schemas/delete-employee-schema.json",
                deleteResponse.asString()
        );
    }
}