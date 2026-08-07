package com.bridgelabz.student_management.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bridgelabz.student_management.model.Student;

public class Main {
	public static void main(String [] args ) {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		
		Student student = context.getBean(Student.class);
		student.display();
	}

}
