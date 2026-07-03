package com.nkosinathi.api.utils;

import com.nkosinathi.api.models.EmployeeRequest;
import net.datafaker.Faker;

public final class EmployeeDataFactory {

    private static final Faker faker = new Faker();

    private EmployeeDataFactory() {
    }

    public static EmployeeRequest createValidEmployee() {

        return new EmployeeRequest(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.options().option(
                        "Information Technology",
                        "Finance",
                        "Human Resources",
                        "Marketing",
                        "Operations"
                ),
                faker.options().option(
                        "Active",
                        "Inactive"
                )
        );
    }

    public static EmployeeRequest createEmployee(String name,
                                                 String email,
                                                 String department,
                                                 String status) {

        return new EmployeeRequest(
                name,
                email,
                department,
                status
        );
    }

    public static EmployeeRequest employeeWithoutName() {

        return new EmployeeRequest(
                "",
                faker.internet().emailAddress(),
                "Information Technology",
                "Active"
        );
    }

    public static EmployeeRequest employeeWithoutEmail() {

        return new EmployeeRequest(
                faker.name().fullName(),
                "",
                "Information Technology",
                "Active"
        );
    }

    public static EmployeeRequest employeeWithInvalidEmail() {

        return new EmployeeRequest(
                faker.name().fullName(),
                "invalid-email",
                "Information Technology",
                "Active"
        );
    }
    public static EmployeeRequest employeeWithoutDepartment() {

        return new EmployeeRequest(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                "",
                "Active"
        );
    }

    public static EmployeeRequest employeeWithoutStatus() {

        return new EmployeeRequest(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                "Information Technology",
                ""
        );
    }

    public static EmployeeRequest emptyEmployee() {

        return new EmployeeRequest(
                null,
                null,
                null,
                null
        );
    }

}