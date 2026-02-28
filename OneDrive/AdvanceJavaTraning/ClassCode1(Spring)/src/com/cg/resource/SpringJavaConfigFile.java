package com.cg.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	@Bean
	public Student Stdid() {
		Student s1 = new Student();
		s1.setId(1001);
		s1.setName("Renu");
		s1.setEmail("renu@gmail.com");
		
		return s1;
	}
	@Bean
	public Student StdObj2() {
		Student s1 = new Student();
		s1.setId(1001);
		s1.setName("Renu");
		s1.setEmail("renu@gmail.com");
		
		return s1;
	}

}
