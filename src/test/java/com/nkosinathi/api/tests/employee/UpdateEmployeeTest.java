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

@Epic("Employee Management API")
@Feature("Employee CRUD")
@Owner("Nkosinathi Jiyane")
public class UpdateEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Update Employee")
    @DisplayName("Verify employee can be updated successfully")
    void shouldUpdateEmployeeSuccessfully() {

        // Arrange - Create employee first
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


        // Act - Update employee
        Response updateResponse =
                EmployeeSteps.updateEmployee(
                        employeeId,
                        updatedEmployee
                );

        updateResponse.prettyPrint();


        // Assert - PUT response
        AIAssertions.verifyStatus(
                updateResponse,
                200,
                "/api/employees/" + employeeId,
                "PUT",
                updatedEmployee
        );

        ResponseAssertions.verifyEmployeeUpdated(updateResponse);

        SchemaAssertions.verifySchema(
                "schemas/update-employee-schema.json",
                updateResponse.asString()
        );


        // Verify persisted changes using GET
        Response getResponse =
                EmployeeSteps.getEmployee(employeeId);

        getResponse.prettyPrint();


        AIAssertions.verifyStatus(
                getResponse,
                200,
                "/api/employees/" + employeeId,
                "GET",
                null
        );

        ResponseAssertions.verifyEmployeeRetrieved(
                getResponse,
                updatedEmployee
        );

        SchemaAssertions.verifySchema(
                "schemas/employee-schema.json",
                getResponse.asString()
        );
    }
}