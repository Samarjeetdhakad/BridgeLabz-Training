package com.inheritance.assistedproblems;


public class AnimalMain {
	public static void main(String args[]) {
		Animal a = new Animal();
		Animal b= new Dog();
		Animal c = new Cat();
		Animal d = new Bird();
		a.makeSound();
		b.makeSound();
		c.makeSound();
		d.makeSound();
		
	}
}