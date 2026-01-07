package petpal;

import java.util.Random;

public  abstract class Pet implements IInteractable {
	private String name;
	private String type;
	private int age;
	
	private int hunger;
	private int energy;
	private int mood;
	
	//default constructor 
	Pet(String name , String type ){
		this.name = name;
		this.type = type;
		this.age = new Random().nextInt(10)+1;
		this.hunger = new Random().nextInt(40) + 30;
        this.energy = new Random().nextInt(40) + 40;
        this.mood = new Random().nextInt(40) + 50;
	}
	
	//user specified constructor
	Pet(String name, String type, int age,String hunger,String energy,String mood){
		this(name, type);
		this.age = age;
	}
	
	protected void changeHunger(int value) {
		hunger = Math.max(0, Math.min(100, hunger + value));
				
	}

	protected void changeEnergy(int value) {
        energy = Math.max(0, Math.min(100, energy + value));
    }
	
	protected void changeMood(int value) {
        mood = Math.max(0, Math.min(100, mood + value));
    }

	
	
	public void showStatus() {
        System.out.println(name + " [" + type + "]");
        System.out.println("Age:" + age);
        System.out.println("Hunger:" + hunger);
        System.out.println("Energy: " + energy);
        System.out.println("Mood: " + mood);
        System.out.println();
    }
	
	abstract void makeSound();
}
