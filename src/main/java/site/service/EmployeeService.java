package site.service;

import site.Employee;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getAllEmployees();
private boolean validateInput(String firstName, String lastName) {
return isAlpha(firstName) && isAlpha(lastName);
}
}
