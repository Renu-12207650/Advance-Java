package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.beans.Student;
//import com.cg.resource.SpringJavaConfigFile;

public class Main {
	public static void main(String[] args) {
		String config_loc = "/com/cg/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);
		Student s1 = (Student) context.getBean(Student.class);
//		Student s2 = (Student) context.getBean("StdObj2",Student.class);
		s1.display();
//		s2.display();
	}

}
