# Employee Management API Automation Framework

A scalable and maintainable API automation framework for testing the Employee Management REST APIs using **Java**, **Rest Assured**, **TestNG**, and **Maven**.

---

## Features

- REST API automation using Rest Assured
- TestNG test execution
- Maven project management
- JSON schema validation
- Request and response logging
- POJO-based request payloads
- Environment-specific configuration
- Extent Reports integration
- Allure Reports integration
- Data-driven testing
- Retry mechanism for failed tests
- Parallel test execution
- CI/CD ready (Jenkins/GitHub Actions)
- Utility classes for reusable methods

---

## Technology Stack

| Technology | Version |
|------------|----------|
| Java | 17+ |
| Maven | Latest |
| Rest Assured | 5.x |
| TestNG | 7.x |
| Jackson | Latest |
| Allure Reports | Latest |
| Extent Reports | Latest |
| Log4j2 | Latest |

---

## Project Structure

```
EmployeeManagementAPIFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   ├── clients
│   │   │   ├── config
│   │   │   ├── constants
│   │   │   ├── models
│   │   │   ├── utils
│   │   │   └── listeners
│   │   │
│   │   └── resources
│   │       ├── config.properties
│   │       └── log4j2.xml
│   │
│   └── test
│       ├── java
│       │   ├── tests
│       │   ├── dataProviders
│       │   └── schemas
│       │
│       └── resources
│           └── testData.json
│
├── reports
├── allure-results
├── test-output
├── pom.xml
├── testng.xml
└── README.md
```

---

## Framework Design

The framework follows a layered architecture.

```
Test Classes
      │
      ▼
API Client Layer
      │
      ▼
Base API Methods
      │
      ▼
Rest Assured
      │
      ▼
Employee Management API
```

---

## Prerequisites

- Java JDK 17 or later
- Maven
- Git
- IDE (IntelliJ IDEA or Eclipse)

Verify installation:

```bash
java -version
mvn -version
```

---

## Installation

Clone the repository.

```bash
git clone https://github.com/your-org/employee-management-api-framework.git
```

Navigate to the project.

```bash
cd employee-management-api-framework
```

Install dependencies.

```bash
mvn clean install
```

---

## Configuration

Update the configuration file.

```
src/main/resources/config.properties
```

Example:

```properties
baseUrl=https://api.company.com
username=admin
password=password
environment=QA
```

---

## Running Tests

Run all tests.

```bash
mvn clean test
```

Run a TestNG suite.

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Run a single test class.

```bash
mvn test -Dtest=EmployeeAPITest
```

Run tests in parallel.

```xml
<suite parallel="methods" thread-count="5">
```

---

## API Coverage

Current automated APIs include:

- Create Employee
- Get Employee
- Get All Employees
- Update Employee
- Delete Employee
- Search Employee
- Authentication
- Authorization
- Negative Scenarios
- Validation Scenarios

---

## Validation Covered

- HTTP Status Codes
- Response Time
- Headers
- Response Body
- JSON Schema Validation
- Authentication
- Error Messages
- Data Integrity

---

## Reporting

### Extent Reports

Generated after execution.

```
reports/ExtentReport.html
```

---

### Allure Reports

Generate report.

```bash
allure serve allure-results
```

---

## Logging

Log4j2 is used for logging.

Logs include:

- Request
- Response
- Headers
- Payload
- Execution Details
- Errors

---

## Data Driven Testing

Supports:

- JSON
- Excel
- CSV
- TestNG DataProvider

---

## Sample Test Flow

```
Authenticate User
        │
        ▼
Create Employee
        │
        ▼
Validate Response
        │
        ▼
Retrieve Employee
        │
        ▼
Update Employee
        │
        ▼
Delete Employee
        │
        ▼
Validate Deletion
```

---

## CI/CD Integration

Compatible with:

- Jenkins
- GitHub Actions
- Azure DevOps
- GitLab CI

Example:

```bash
mvn clean test
```

Publish:

- Extent Report
- Allure Report
- TestNG Results

---

## Best Practices

- Keep test data external.
- Use reusable API clients.
- Validate every response.
- Avoid hardcoded values.
- Maintain environment configurations separately.
- Use POJOs instead of raw JSON.
- Keep assertions meaningful.
- Follow naming conventions.

---

## Future Enhancements

- Docker Support
- Kubernetes Integration
- Contract Testing
- Performance Testing
- OAuth2 Support
- API Mocking
- Database Validation
- Swagger Validation

---

## Troubleshooting

### Dependency Issues

```bash
mvn clean install -U
```

### Clear Reports

```bash
mvn clean
```

### Skip Tests

```bash
mvn clean install -DskipTests
```

---

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your branch.
5. Create a Pull Request.

---

## License

This project is licensed under the MIT License.

---

## Author

API Automation Framework

Built using:

- Java
- Rest Assured
- TestNG
- Maven
- Allure Reports
- Extent Reports