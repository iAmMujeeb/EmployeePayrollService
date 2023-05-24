package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIOImpl implements PayrollService {

    static final String filePath = "D:\\manu\\New folder (2)\\newfolder1\\MavenSample273\\src\\main\\java\\com\\bridgelabz\\employee.txt";

    @Override
    public void writeDataToDestination(List<Employee> employeeList) throws IOException {
        StringBuffer sb = new StringBuffer();
        employeeList.stream().forEach(employee -> {
            String empString = employee.toString().concat("\n");
            sb.append(empString);
        });
        Files.write(Path.of(filePath),sb.toString().getBytes());
    }

    @Override
    public void readDataFromDestination() throws IOException {
        Files.lines(Path.of(filePath)).forEach(employee -> {
            System.out.println(employee);
        });
    }

    @Override
    public long countEntriesFromDestination() throws IOException {
        long count = Files.lines(Path.of(filePath)).count();
        return count;
    }
}
