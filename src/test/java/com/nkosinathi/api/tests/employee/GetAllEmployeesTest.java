package com.nkosinathi.api.tests.employee;

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
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("message", equalTo("Employees retrieved successfully."))
                .body("data", notNullValue())
                .body("data", not(empty()))
                .body(matchesJsonSchemaInClasspath("schemas/employees-schema.json"));

        System.out.println(
                GetAllEmployeesTest.class.getClassLoader()
                        .getResource("schemas/employees-schema.json")
        );
    }
}