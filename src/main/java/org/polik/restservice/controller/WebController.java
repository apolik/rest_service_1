package org.polik.restservice.controller;

import org.polik.restservice.entity.Employee;
import org.polik.restservice.exceptionhandling.EmployeeNotFoundException;
import org.polik.restservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class WebController {
    private EmployeeService service;

    @Autowired
    public WebController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> showAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> showEmployeeById(@PathVariable long id) {
        Employee result = service.getEmployeeById(id);

        if (result == null)
            throw new EmployeeNotFoundException(String.format("There's no employee with id %d.", id));
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        if (employee.isValid()) {
            service.saveEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Please check out input data!");
        }
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        if (employee.isValid()) {
            service.saveEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Please check out input data!");
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        if (service.deleteEmployee(id))
            return new ResponseEntity<>(String.format("Employee with id %d has been deleted", id), HttpStatus.OK);
        else
            return new ResponseEntity<>(String.format("No such employee with id %d", id), HttpStatus.NOT_FOUND);
    }
}
