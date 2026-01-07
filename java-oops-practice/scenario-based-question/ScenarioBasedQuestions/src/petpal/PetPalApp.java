package petpal;


public class PetPalApp {
public static void main(String[]args) {
		
		Pet pet1 = new Dog("Buddy");
		Pet pet2 = new Cat("Whisker");
		Pet pet3 = new Birds("Tweety");
		
		Pet [] pets = {pet1, pet2 , pet3};
		
		for(Pet pet:pets) {
			
			pet.makeSound();
			pet.feed();
			pet.play();
			pet.sleep();
			pet.showStatus();
			
		}
		
	}

}
