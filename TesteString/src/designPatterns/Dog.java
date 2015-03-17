package designPatterns;
import designPatterns.Animal;

public class Dog implements Animal{

	public static void Bark(){
		System.out.println("Bark");
	}
	
	@Override
	public void makesound() {
		// TODO Auto-generated method stub
		Bark();
	}

}
