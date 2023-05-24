package com.bridgelabz;

import java.io.IOException;
import java.util.List;

public interface PayrollService {

    void writeDataToDestination(List<Employee> employeeList) throws IOException;

    void readDataFromDestination() throws IOException;

    long countEntriesFromDestination() throws IOException;

}
