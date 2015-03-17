package designPatterns;

public class Cat implements Animal{

	public void Meow(){
		System.out.println("Meow");
	}
	
	@Override
	public void makesound() {
		// TODO Auto-generated method stub
		Meow();
	}

}
