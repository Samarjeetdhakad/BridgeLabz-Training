package petpal;

public class Cat extends Pet {

    public Cat(String name) {
        super(name, "Cat");
    }

    @Override
    public void feed() {
        changeHunger(-15);
        changeMood(+5);
        System.out.println("Cat is eating quietly ");
    }

    @Override
    public void play() {
        changeEnergy(-10);
        changeMood(+15);
        System.out.println("Cat is chasing a laser ");
    }

    @Override
    public void sleep() {
        changeEnergy(+40);
        System.out.println("Cat is napping ");
    }

    @Override
    public void makeSound() {
        System.out.println(" Meow");
    }
}
