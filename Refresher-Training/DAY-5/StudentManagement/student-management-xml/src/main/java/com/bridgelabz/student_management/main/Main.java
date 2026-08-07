package com.bridgelabz.student_management.main;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.student_management.model.Student;

public class Main {
	public static void main(String [] args ) {
		ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = context.getBean("student",Student.class);
		student.displayStudent();
	}

}
