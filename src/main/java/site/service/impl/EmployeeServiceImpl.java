package site.service.impl;

import org.springframework.stereotype.Service;
import site.Employee;
import site.exceptions.EmployeeAlreadyAddedException;
import site.exceptions.EmployeeNotFoundException;
import site.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee employee1 = findEmployee(firstName, lastName);
        if (employees != null) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add((Employee) employees);
        return (Employee) employees;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
if(!employees.contains(employee)){
    throw new EmployeeNotFoundException();
}
employees.remove(employee);

        return (Employee) employees;
    }


        @Override
        public Employee findEmployee (String firstName, String lastName){
            Employee findEmployee = new Employee(firstName,lastName);
            for (Employee employee1: employees) {
                if(employees.equals(findEmployee)){
                    return (Employee) employees;
                }
                }
            return null;
        }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}


