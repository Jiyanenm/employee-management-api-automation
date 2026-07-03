package com.nkosinathi.api.context;

public final class TestContext {

    private static String employeeId;

    private TestContext() {
    }

    public static String getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(String employeeId) {
        TestContext.employeeId = employeeId;
    }

}