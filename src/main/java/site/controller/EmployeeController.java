package site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.Employee;
import site.exceptions.EmployeeNotFoundException;
import site.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService = null;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department")Integer department, @RequestParam("salary")Integer salary) {

        Employee employee = employeeService.addEmployee(firstName, lastName, salary, department);
        return null;
    }




    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
}
