package com.nkosinathi.api.steps;

import com.nkosinathi.api.client.EmployeeClient;
import com.nkosinathi.api.models.EmployeeRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class EmployeeSteps {

    private EmployeeSteps() {
    }

    // Create
    public static Response createEmployeeResponse(EmployeeRequest employee) {

        Response response = EmployeeClient.createEmployee(employee);

        response.then().statusCode(201);

        return response;
    }
    @Step("Create employee")
    public static String createEmployee(EmployeeRequest employee) {

        Response response = createEmployeeResponse(employee);

        String employeeId = response.jsonPath().getString("data");

        assertNotNull(employeeId, "Employee ID should not be null");

        return response.jsonPath().getString("data");
    }

    @Step("Retrieve employee with ID: {employeeId}")
    public static Response getEmployee(String employeeId) {

        Response response = EmployeeClient.getEmployeeById(employeeId);

        response.then().statusCode(200);

        return response;
    }
    @Step("Retrieve all employees")
    public static Response getAllEmployees() {

        Response response = EmployeeClient.getAllEmployees();

        response.then().statusCode(200);

        return response;
    }
    @Step("Update employee: {employeeId}")
    public static Response updateEmployee(String employeeId, EmployeeRequest employee) {

        Response response = EmployeeClient.updateEmployee(employeeId, employee);

        response.then().statusCode(200);

        return response;
    }

    @Step("Delete employee: {employeeId}")
    public static Response deleteEmployee(String employeeId) {

        Response response = EmployeeClient.deleteEmployee(employeeId);

        response.then().statusCode(200);

        return response;
    }

    @Step("Search employees by department: {department}")
    public static Response searchEmployeesByDepartment(String department) {

        Response response =
                EmployeeClient.searchEmployeesByDepartment(department);

        response.then().statusCode(200);

        return response;
    }
}