package com.nkosinathi.api.tests.regression;

import com.nkosinathi.api.tests.employee.*;
import com.nkosinathi.api.tests.negative.CreateEmployeeNegativeTest;
import io.qameta.allure.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CreateEmployeeTest.class,
        GetEmployeeTest.class,
        GetAllEmployeesTest.class,
        UpdateEmployeeTest.class,
        DeleteEmployeeTest.class,
        SearchEmployeeTest.class,
        CreateEmployeeNegativeTest.class
})
@Epic("Employee Management API")
@Feature("Employee CRUD")
@Severity(SeverityLevel.CRITICAL)
@Story("Regression Testing")
@Owner("Nkosinathi Jiyane")
public class EmployeeRegressionTest {
}