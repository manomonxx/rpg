package designPatterns;

public class MainAnimal {

	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.makesound();
		
		Animal animal2 = new Cat();
		animal2.makesound();
		
		//Factory Animal
		FactoryAnimal fanimal = new FactoryAnimal("cat");
		fanimal.getAnimal().makesound();
	}

}
