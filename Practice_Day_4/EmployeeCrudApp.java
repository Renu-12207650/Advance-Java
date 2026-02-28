package com.lpu.practice;

import com.lpu.dao.EmployeeDAO;
import com.lpu.entities.Employee;

public class EmployeeCrudApp {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // CREATE
        dao.save(new Employee("Abhinav", "IT", 50000));

        // READ
        dao.getAll().forEach(System.out::println);

        // UPDATE
        dao.updateSalary(1, 80000);

        // DELETE
        dao.delete(1);
    }
}
