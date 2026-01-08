package com.linkedlist.singlylinkedlist.studentrecordmanagementsystem;

public class StudentLinkedList {
	private StudentNode head;
	
	
	public void addAtBeginning(int roll, String name, int age, char grade) {
		StudentNode newNode = new StudentNode( roll,  name, age, grade);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next  = head;
		head = newNode;
	}
	
	
	public void addAtPosition(int position, int roll, String name, int age, char grade) {

        if (position == 1) {
        	addAtBeginning(roll, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
	
	
	
	
	public void addAtEnd(int roll, String name, int age, char grade) {
		StudentNode newNode = new StudentNode(roll,  name, age, grade);
		if(head == null) {
			head = newNode;
			return;
		}
		
		StudentNode currNode = head;
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		
		currNode.next = newNode;
		
	}
	
	
	public void deleteByRollNumber(int roll) {
		if(head == null) {
			System.out.println("List is empty");
			return ;
		}
		
		if(head.rollNumber == roll) {
			head = head.next;
			return;
		}
		
		StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
        }
		
	}
	
	// search by roll number
	public void search(int roll) {
		StudentNode temp = head;
		
		while(temp!= null) {
			if(temp.rollNumber == roll) {
				  System.out.println("Found Student = "
	                        + temp.rollNumber + " "
	                        + temp.name + " "
	                        + temp.age + " "
	                        + temp.grade);
	                return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found !");
	} 
	
	
	public void updateGrade(int roll, char newGrade) {
		 StudentNode temp = head;

	        while (temp != null) {
	            if (temp.rollNumber == roll) {
	                temp.grade = newGrade;
	                System.out.println("Grade updated successfully");
	                return;
	            }
	            temp = temp.next;
	        }  
	        System.out.println("Student not found");
	}
	
	
	
	
	public void display() {
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		StudentNode currNode = head;
		while(currNode!= null) {
			System.out.println("Name " + currNode.name);
			System.out.println("Roll Number " + currNode.rollNumber);
			System.out.println("age " + currNode.age);
			System.out.println("grade " + currNode.grade);
			currNode = currNode.next;
		}
		
		
		System.out.println("Null ");

	}
	
	
}