package com.nkosinathi.api.tests.negative;

import com.nkosinathi.api.base.BaseTest;
import com.nkosinathi.api.client.EmployeeClient;
import com.nkosinathi.api.models.EmployeeRequest;
import com.nkosinathi.api.utils.EmployeeDataFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;


@Epic("Employee Management API")
@Feature("Negative Testing - Employee Creation")
public class CreateEmployeeNegativeTest extends BaseTest {

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Should reject employee creation when name is missing")
    @DisplayName("Create Employee - Missing Name")
    void shouldRejectEmployeeWithoutName() {

        EmployeeRequest employee =
                EmployeeDataFactory.employeeWithoutName();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Should reject employee creation when email is missing")
    @DisplayName("Create Employee - Missing Email")
    void shouldRejectEmployeeWithoutEmail() {

        EmployeeRequest employee =
                EmployeeDataFactory.employeeWithoutEmail();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.NORMAL)
    @Description("Should reject employee creation when email format is invalid")
    @DisplayName("Create Employee - Invalid Email")
    void shouldRejectEmployeeWithInvalidEmail() {

        EmployeeRequest employee =
                EmployeeDataFactory.employeeWithInvalidEmail();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Should reject employee creation when department is missing")
    @DisplayName("Create Employee - Missing Department")
    void shouldRejectEmployeeWithoutDepartment() {

        EmployeeRequest employee =
                EmployeeDataFactory.employeeWithoutDepartment();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Should reject employee creation when status is missing")
    @DisplayName("Create Employee - Missing Status")
    void shouldRejectEmployeeWithoutStatus() {

        EmployeeRequest employee =
                EmployeeDataFactory.employeeWithoutStatus();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }

    @Test
    @Story("Create Employee")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Should reject completely empty employee request")
    @DisplayName("Create Employee - Empty Request")
    void shouldRejectEmptyEmployeeRequest() {

        EmployeeRequest employee =
                EmployeeDataFactory.emptyEmployee();

        Response response =
                EmployeeClient.createEmployee(employee);

        response.prettyPrint();

        response.then()
                .statusCode(anyOf(
                        equalTo(400),
                        equalTo(500)
                ));

        if (response.jsonPath().get("success") != null) {
            response.then().body("success", equalTo(false));
        }
        validateSchema(
                "schemas/error-schema.json",
                response.asString()
        );
    }
}