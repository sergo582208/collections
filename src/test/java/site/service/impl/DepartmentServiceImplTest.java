package site.service.impl;

import ch.qos.logback.core.joran.spi.ElementPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import site.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> Employees = new ArrayList<>() {{
        add(new Employee("Sara", "Connor", 100000, 1));
        add(new Employee("Vladimir", "Putin", 200000, 1));
        add(new Employee("Grigoriy", "Leps", 300000, 1));
    }};

    private Employee[] employees;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.getAllEmployees()).thenReturn((List<Employee>) employeeMap);

        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        //then
        Assertions.assertEquals(employees.getClass(), employeeWithMaxSalary);
    }

    @Test
    void shouldReturnNullWhenNoEmployeesInDepartment() {
        //given
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.getAllEmployees()).thenReturn((List<Employee>) employeeMap);

        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        //then
        Assertions.assertNull(employeeWithMaxSalary);
    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.getAllEmployees()).thenReturn((List<Employee>) employeeMap);

        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);
        //then
        Assertions.assertEquals(employees.getClass(), employeeWithMinSalary);
    }

    @Test
    void shouldReturnGroupedByDepartmentEmployees() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.getAllEmployees()).thenReturn((List<Employee>) employeeMap);

        //when
        Employee groupedByDepartmentEmployees = (Employee) departmentService.getGroupedByDepartmentEmployees(departmentId);
        //then
        Assertions.assertEquals(employees.getClass(), groupedByDepartmentEmployees);
    }
}