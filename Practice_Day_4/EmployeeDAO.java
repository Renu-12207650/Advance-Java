package com.lpu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lpu.entities.Employee;
import com.lpu.config.HibernateUtil;
import java.util.List;

public class EmployeeDAO {

    // CREATE
    public void save(Employee emp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp);

        tx.commit();
        session.close();
    }

    // READ ALL
    public List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
    }

    // UPDATE
    public void updateSalary(int id, double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setSalary(salary);
            session.update(emp);
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
        }

        tx.commit();
        session.close();
    }
}
