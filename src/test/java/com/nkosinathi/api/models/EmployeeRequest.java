package com.nkosinathi.api.models;

public class EmployeeRequest {

    private String name;
    private String email;
    private String department;
    private String status;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String email, String department, String status) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}