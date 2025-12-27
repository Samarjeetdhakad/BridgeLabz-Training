package com.constructor.level1;

public class PersonMain {
	
public static void main(String[] args) {
	Person p1 = new Person(24, "samar", 34000);
	Person p2 = new Person(p1);
	
	p1.display();
	p2.display();
	
}
}
