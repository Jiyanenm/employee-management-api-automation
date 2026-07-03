package com.nkosinathi.api.tests.employee;

import com.nkosinathi.api.base.BaseTest;
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
@Owner("Nkosinathi Jiyane")
public class SearchEmployeeTest extends BaseTest {

//    @Test
//    @DisplayName("Verify employee can be searched by name")
//    void shouldSearchEmployeeByName() {
//
//        // Arrange
//        EmployeeRequest employee = EmployeeDataFactory.createEmployee(
//                "Automation Tester",
//                "automation@test.com",
//                "Information Technology",
//                "Active"
//        );
//
//        EmployeeSteps.createEmployee(employee);
//
//        // Act
//        Response response = EmployeeSteps.searchEmployees("Nkosinathi Jiyane");
//
//        response.prettyPrint();
//
//        // Assert
//        response.then()
//                .statusCode(200)
//                .body("success", equalTo(true))
//                .body("message", equalTo("Employees retrieved successfully."))
//                .body("data", not(empty()))
//                .body("data.name", hasItem(employee.getName()))
//                .body("data.email", hasItem(employee.getEmail()));
//    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Search Employee")
    @DisplayName("Verify employee can be searched by department")
    void shouldSearchEmployeeByDepartment() {

        EmployeeRequest employee = EmployeeDataFactory.createEmployee(
                "Finance User",
                "finance@test.com",
                "Finance",
                "Active"
        );

        EmployeeSteps.createEmployee(employee);

        Response response =
                EmployeeSteps.searchEmployeesByDepartment("Information technology");
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data.department", hasItem("Information technology"));
    }
//    @Test
//    @DisplayName("Verify search returns no results for an unknown employee")
//    void shouldReturnEmptyListForUnknownEmployee() {
//
//        Response response =
//                EmployeeSteps.searchEmployeesByDepartment("EmployeeThatDoesNotExist123");
//
//        response.then()
//                .statusCode(200)
//                .body("success", equalTo(true))
//                .body("message", equalTo("Search completed successfully."))
//                .body("data", empty());
//    }
}