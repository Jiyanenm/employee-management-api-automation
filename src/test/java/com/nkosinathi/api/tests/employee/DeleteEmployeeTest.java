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
public class DeleteEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Employee")
    @DisplayName("Verify employee can be deleted successfully")
    void shouldDeleteEmployeeSuccessfully() {

        // Arrange
        EmployeeRequest employee =
                EmployeeDataFactory.createValidEmployee();

        String employeeId =
                EmployeeSteps.createEmployee(employee);

        // Act
        Response deleteResponse =
                EmployeeSteps.deleteEmployee(employeeId);

        // AI Status Assertion
        AIAssertions.verifyStatus(
                deleteResponse,
                200,
                "/api/employees/" + employeeId,
                "DELETE",
                null
        );

        AIAssertions.verifyStatus(deleteResponse, 200);

        ResponseAssertions.verifyEmployeeDeleted(deleteResponse);

        SchemaAssertions.verifySchema(
                "schemas/delete-employee-schema.json",
                deleteResponse.asString()
        );
    }
}