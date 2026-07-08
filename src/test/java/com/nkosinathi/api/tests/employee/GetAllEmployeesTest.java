package com.nkosinathi.api.tests.employee;

import com.nkosinathi.api.assertions.AIAssertions;
import com.nkosinathi.api.assertions.ResponseAssertions;
import com.nkosinathi.api.assertions.SchemaAssertions;
import com.nkosinathi.api.base.BaseTest;
import com.nkosinathi.api.client.EmployeeClient;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Epic("Employee Management API")
@Feature("Employee Retrieval")
@Owner("Nkosinathi Jiyane")
public class GetAllEmployeesTest extends BaseTest {

    @Test
    @Story("Retrieve All Employees")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify all employees can be retrieved successfully.")
    @DisplayName("Retrieve All Employees")
    void shouldRetrieveAllEmployees() {

        // Act
        Response response = EmployeeClient.getAllEmployees();

        response.prettyPrint();

        // Assert
        AIAssertions.verifyStatus(response, 200);

        ResponseAssertions.verifyEmployees(response);

        SchemaAssertions.verifySchema(
                "schemas/employees-schema.json",
                response.asString()
        );
    }
}