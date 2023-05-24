package com.bridgelabz;

import java.io.IOException;
import java.util.List;

public class EmployeeService {

    List<Employee> employeeList;

    PayrollService payrollService;

    public EmployeeService(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeService(List<Employee> employeeList, PayrollService payrollService) {
        this(employeeList);
        this.payrollService = payrollService;

    }

        PayrollService payrollService1 = new ConsoleIOImpl();
        PayrollService payrollService2 = new DatabaseIOImpl();
        PayrollService payrollService3 = new CloudIOImpl();
    public void writeData() {
        try {
            payrollService.writeDataToDestination(employeeList);
        } catch (IOException e) {
            System.out.println("catch");
        }
//
    }

    public void readData() {
        try {
            payrollService.readDataFromDestination();
        } catch (IOException e) {
            System.out.println("catch");
        }
    }

    public Long countEntries() {
        Long count = null;
        try {
            count = payrollService.countEntriesFromDestination();
        } catch (IOException e) {
            System.out.println("catch");
        }
        return count;
    }
}
