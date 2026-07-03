# 🚀 Employee Management API

<div align="center">

A Production-Ready RESTful Employee Management API built with Java, Spring Boot & Firebase Firestore.

🌐 Live API: https://employee-management-api-1-j5k2.onrender.com

</div>

---

## 📖 Overview

This project is a **Spring Boot-based Employee Management System** that provides full CRUD operations, validation, negative testing, and automated API regression testing using **JUnit 5, RestAssured, and Allure Reports**.

It also includes a **CI/CD pipeline using GitHub Actions** for automated testing and reporting.

---

## ✨ Features

- Create, Read, Update, Delete Employees
- Search Employee by ID / Name
- Firebase Firestore Integration
- Input Validation & Exception Handling
- Negative Test Scenarios
- Automated Regression Suite
- Allure Reporting
- CI/CD Pipeline (GitHub Actions)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Firebase Firestore
- JUnit 5
- RestAssured
- Allure Reports
- Maven
- GitHub Actions (CI/CD)

---

## 📁 Project Structure

com.nkosinathi.employeemanagement
│
├── controller
├── service
├── repository
├── model
├── dto
├── config
├── exception
└── tests
├── employee
├── negative
└── regression


---

## 🚀 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /employees | Create employee |
| GET    | /employees/{id} | Get employee by ID |
| GET    | /employees | Get all employees |
| PUT    | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |
| GET    | /employees/search?name= | Search employee |

---

## 🧪 Running Tests Locally

### Run all tests

bash mvn clean test 
mvn clean test -Dgroups=regression

## Running Tests Locally

mvn allure:report

Open report - mvn allure:serve

## CI/CD Pipeline (GitHub Actions)

This project includes automated CI/CD using GitHub Actions.

Workflow file: .github/workflows/employee-api-ci.yml

## CI/CD Pipeline (GitHub Actions)
On every push or pull request to main branch:

Checkout repository
Setup Java 17
Run Maven tests
Execute regression suite
Generate Allure results
Upload test artifacts

Example GitHub Actions Workflow :

name: Employee API CI/CD Pipeline

on:
push:
branches: [main]
pull_request:
branches: [main]

jobs:
test:
runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Run Tests
        run: mvn clean test

      - name: Generate Allure Report
        run: mvn allure:report

      - name: Upload Allure Results
        uses: actions/upload-artifact@v4
        with:
          name: allure-results
          path: target/allure-results

## CI/CD Pipeline (GitHub Actions)

After running pipeline:

Go to GitHub repository
Click Actions tab
Select latest workflow run
Scroll down to Artifacts
Download:
allure-results

## CI/CD Pipeline (GitHub Actions)

mvn allure:serve

OR:

allure generate target/allure-results -o allure-report --clean
allure open allure-report

## 👤 Author

Nkosinathi Jiyane
QA Engineer | SDET (Java + API Automation)

