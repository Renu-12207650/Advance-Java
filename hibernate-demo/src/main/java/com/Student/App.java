package com.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        // ================= INSERT =================
        session.beginTransaction();

        Student s1 = new Student("Sonu","REG101","sonu@gmail.com");
        Student s2 = new Student("Riya","REG102","riya@gmail.com");

        session.persist(s1);
        session.persist(s2);

        session.getTransaction().commit();
        System.out.println("Insert Done");

        // ================= READ =================
        List<Student> list =
                session.createQuery("from Student", Student.class).list();

        System.out.println("---- Student List ----");
        for(Student s : list) {
            System.out.println(
                    s.getId()+" "+
                    s.getName()+" "+
                    s.getRegistrationNumber()+" "+
                    s.getEmail());
        }

        // ================= UPDATE =================
        session.beginTransaction();

        Student updateStudent = session.get(Student.class, 1);
        if(updateStudent != null){
            updateStudent.setName("Updated Sonu");
        }

        session.getTransaction().commit();
        System.out.println("Update Done");

        // ================= DELETE =================
        session.beginTransaction();

        Student deleteStudent = session.get(Student.class, 2);
        if(deleteStudent != null){
            session.remove(deleteStudent);
        }

        session.getTransaction().commit();
        System.out.println("Delete Done");

        session.close();
        factory.close();
    }
}
 