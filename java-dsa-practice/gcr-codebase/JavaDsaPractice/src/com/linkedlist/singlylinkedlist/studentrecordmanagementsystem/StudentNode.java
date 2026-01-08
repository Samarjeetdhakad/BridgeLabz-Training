package com.linkedlist.singlylinkedlist.studentrecordmanagementsystem;

public class StudentNode {
	
	int rollNumber;
	String name;
	int age;
	char grade;
	StudentNode next ;
	
	
	StudentNode(int rollNumber, String name, int age, char grade){
		this.rollNumber = rollNumber;
		this.name = name;
		this.age =  age;
		this.grade = grade;
		this.next = null;
	}
	
}