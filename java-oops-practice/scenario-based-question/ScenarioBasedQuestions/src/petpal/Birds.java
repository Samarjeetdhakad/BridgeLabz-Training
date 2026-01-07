package petpal;

public class Birds extends Pet{
	
	public Birds(String name) {
		super(name, "Birds");
	}
	
	 @Override
	    public void feed() {
		 changeHunger(-10);changeMood(+10);System.out.println("Bird is pecking seeds ");
		 }
	
	 @Override
	    public void play() {
	        changeEnergy(-15);
	        changeMood(+20);
	        System.out.println("Bird is flying around 🕊");
	    }
	 
	 @Override
	    public void sleep() {
	        changeEnergy(+25);
	        System.out.println("Bird is resting ");
	    }
	 
	@Override
	void makeSound() {
		System.out.println("chirping");
	}

}
