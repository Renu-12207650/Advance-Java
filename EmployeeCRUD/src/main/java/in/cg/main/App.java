package in.cg.main;

import in.cg.dao.EmployeeDAO;
import in.cg.entities.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	EmployeeDAO dao = new EmployeeDAO();
    	
        dao.save(new Employee(1, "Abhinav", "IT", 50000));

        dao.getAll().forEach(System.out::println);

        dao.updateSalary(1, 80000);

        dao.delete(1);
    }
}
