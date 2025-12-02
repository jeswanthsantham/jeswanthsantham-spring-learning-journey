package com.example.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Student {
	private String studentName;
	private String department;
	
//	@Autowired-  inject the dependency in the config class
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getStudentName() {
		return studentName;
	}
	@Value("Achyuth")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	@Value("Computer Science")
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + ", course=" + course + "]";
	}

	
}
