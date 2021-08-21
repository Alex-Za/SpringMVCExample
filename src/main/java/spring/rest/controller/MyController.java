package spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.Employee;
import spring.rest.exception_handling.EmployeeIncorrectData;
import spring.rest.exception_handling.NoSuchEmployeeException;
import spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmpoloyees = employeeService.getAllEmployees();
        return allEmpoloyees;
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " long Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }
}
