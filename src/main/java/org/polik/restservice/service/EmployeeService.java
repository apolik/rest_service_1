package org.polik.restservice.service;

import org.polik.restservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    boolean deleteEmployee(long id);
}
