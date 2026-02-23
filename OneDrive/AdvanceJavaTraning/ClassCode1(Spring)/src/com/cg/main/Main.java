package com.cg.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.beans.Student;
import com.cg.resource.*;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		Student s1 = (Student) context.getBean("Stdid",Student.class);
		Student s2 = (Student) context.getBean("StdObj2",Student.class);
		s1.display();
		s2.display();
	}

}
