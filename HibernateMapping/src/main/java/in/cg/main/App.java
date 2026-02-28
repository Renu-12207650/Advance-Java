package in.cg.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.config.HibernateUtil;
import in.cg.entities.Bank;
import in.cg.entities.Customers;
import in.cg.entities.Profile;
import in.cg.entities.User;

public class App 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	
    	// for bank and customers one to many mapping ->
    	
    	Customers c1 = new Customers();
    	c1.setCustomerName("ABHINAV");
    	Customers c2= new Customers();
    	c2.setCustomerName("ABHI");
    	
    	Bank b = new Bank();
    	
    	b.setName("Punjab National bank");
    	b.setCustomer(List.of(c1, c2));
    	
    	session.save(b);
    	tx.commit();
    	session.close();
    	
    	
    	
    	
    	// for user and profile one to one mapping ->
    	
//    	Profile pNo = new Profile();
//    	
//    	pNo.setProfileNumber("abhi15");
//
//    	User user = new User();
//    	user.setName("Abhinav Choudhary");
//    	user.setProfile(pNo);
//    	
//	    session.save(user);
//	    
//	    tx.commit();
//	    session.close();
    	
    }
}
