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
public class UpdateEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Update Employee")
    @DisplayName("Verify employee can be updated successfully")
    void shouldUpdateEmployeeSuccessfully() {

        // Arrange
        EmployeeRequest originalEmployee =
                EmployeeDataFactory.createValidEmployee();

        String employeeId =
                EmployeeSteps.createEmployee(originalEmployee);

        EmployeeRequest updatedEmployee =
                EmployeeDataFactory.createEmployee(
                        "Updated User",
                        "updated@test.com",
                        "Finance",
                        "Inactive"
                );

        // Act
        Response updateResponse =
                EmployeeSteps.updateEmployee(employeeId, updatedEmployee);

        updateResponse.prettyPrint();

        // Assert update response
        updateResponse.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("message", equalTo("Employee updated successfully."));

        // Verify persisted changes
        Response getResponse =
                EmployeeSteps.getEmployee(employeeId);

        getResponse.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data.id", equalTo(employeeId))
                .body("data.name", equalTo(updatedEmployee.getName()))
                .body("data.email", equalTo(updatedEmployee.getEmail()))
                .body("data.department", equalTo(updatedEmployee.getDepartment()))
                .body("data.status", equalTo(updatedEmployee.getStatus()));
    }
}