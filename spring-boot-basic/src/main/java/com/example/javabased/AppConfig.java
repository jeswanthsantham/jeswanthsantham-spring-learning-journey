package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // has been definition
public class AppConfig {
	
	@Bean
	// this is a bean definition
	// the method name is the beanName
	Student getStudent() {
		Student student = new Student();
		student.setCourse(course());
		return student;
		
	}
	
	@Bean
	Course course() {
		return new Course();
	}

}
