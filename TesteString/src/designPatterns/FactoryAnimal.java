package designPatterns;

public class FactoryAnimal {

	private String breed;
	
	public FactoryAnimal(String breed){
		this.breed = breed.toLowerCase();
	}
	
	public Animal getAnimal(){

		if(this.breed.equals("dog")){
			return new Dog();
		}else{
			if(this.breed.equals("cat")){
				return new Cat();
			}
		}
		
		return null;
	}
}
