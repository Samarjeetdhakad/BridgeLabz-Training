package petpal;

public class Dog extends Pet {

    public Dog(String name) {
        super(name, "Dog");
    }

    @Override
    public void feed() {
        changeHunger(-20);
        changeMood(+10);
        System.out.println("Dog is happily eating");
    }

    @Override
    public void play() {
        changeEnergy(-20);
        changeMood(+20);
        System.out.println("Dog is playing fetch");
    }

    @Override
    public void sleep() {
        changeEnergy(+30);
        System.out.println("Dog is sleeping ");
    }

    @Override
    public void makeSound() {
        System.out.println("bark");
    }
}
