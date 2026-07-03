package com.nkosinathi.api.client;

import com.nkosinathi.api.models.EmployeeRequest;
import io.restassured.response.Response;

public class EmployeeClient extends BaseClient {

    private static final EmployeeClient CLIENT = new EmployeeClient();

    private EmployeeClient() {
    }

    public static Response getAllEmployees() {
        return CLIENT.get("");
    }

    public static Response getEmployeeById(String id) {
        return CLIENT.get("/" + id);
    }

    public static Response createEmployee(EmployeeRequest employee) {
        return CLIENT.post("", employee);
    }

    public static Response updateEmployee(String id, EmployeeRequest employee) {
        return CLIENT.put("/" + id, employee);
    }

    public static Response deleteEmployee(String id) {
        return CLIENT.delete("/" + id);
    }

    public static Response searchEmployees(String keyword) {
        return CLIENT.get("/search", "keyword", keyword);
    }
    public static Response searchEmployeesByDepartment(String department) {
        return CLIENT.get("/search/department", "department", department);
    }
}