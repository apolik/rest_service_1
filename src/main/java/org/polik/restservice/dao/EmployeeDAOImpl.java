package org.polik.restservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.polik.restservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory database;

    @Autowired
    public EmployeeDAOImpl(SessionFactory database) {
        this.database = database;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = database.getCurrentSession();

        List<Employee> result = session.createQuery("from Employee", Employee.class).getResultList();

        return result;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = database.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Session session = database.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public boolean deleteEmployee(long id) {
        Session session = database.getCurrentSession();
        int result = session.createQuery("delete from Employee where id =:id").setParameter("id", id).executeUpdate();
        return result == 1;
    }

    @Override
    public void close() {
        database.close();
    }
}
