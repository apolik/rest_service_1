package org.polik.restservice.dao;

import org.polik.restservice.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    boolean deleteEmployee(long id);
    void close();
}
