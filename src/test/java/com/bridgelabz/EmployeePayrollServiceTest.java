package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceTest {

    @Test
    void givenThreeEmployeesWhenWrittenToFileShouldReturnCount() {
        Employee employee1 = new Employee(1, "Amit", 45000);
        Employee employee2 = new Employee(2, "Ajay", 47000);
        Employee employee3 = new Employee(3, "Arun", 49000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        PayrollService payrollService = new FileIOImpl();
        EmployeeService employeeService = new EmployeeService(employeeList,payrollService);
        employeeService.writeData();
        employeeService.readData();
        long actualCount = employeeService.countEntries();
        Assertions.assertEquals(3,actualCount);

    }
    @Test
    void givenThreeEmployeesWhenWrittenToDatabaseShouldReturnCount() {
        Employee employee1 = new Employee(1, "Amit", 45000);
        Employee employee2 = new Employee(2, "Ajay", 47000);
        Employee employee3 = new Employee(3, "Arun", 49000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        PayrollService payrollService = new DatabaseIOImpl();
        EmployeeService employeeService = new EmployeeService(employeeList,payrollService);
        employeeService.writeData();
        employeeService.readData();
        long actualCount = employeeService.countEntries();
        Assertions.assertEquals(3,actualCount);

    }


}
