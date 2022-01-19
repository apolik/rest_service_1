package org.polik.restservice.service;

import org.polik.restservice.dao.EmployeeDAO;
import org.polik.restservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO database;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO database) {
        this.database = database;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return database.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        database.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(long id) {
        return database.getEmployeeById(id);
    }

    @Override
    @Transactional
    public boolean deleteEmployee(long id) {
        return database.deleteEmployee(id);
    }

    @PreDestroy
    private void destroy() {
        database.close();
    }
}
