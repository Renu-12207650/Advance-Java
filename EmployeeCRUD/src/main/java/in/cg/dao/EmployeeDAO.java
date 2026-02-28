package in.cg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.config.HibernateUtil;
import in.cg.entities.Employee;

public class EmployeeDAO {
	public void save(Employee emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		
		tx.commit();
		session.close();
		
	}
	
	public List<Employee> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
	}
	
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
