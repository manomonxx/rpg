package rpg;


public class dungeonsAndGambiarras {

	public static void main(String[] args) {
		System.out.println("----------------------------------");
		System.out.println("Mago:");
		System.out.println("----------------------------------");
		Personagem personagem = new Mago();
		personagem.setName("Fernando");
		personagem.performClass();
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		
		personagem.performExpUp(2000); //2000 de exp
		System.out.println(personagem.performStatus().get("int"));
		
		//personagem.performLevel();
		//personagem.performLevel();
		//personagem.performUpInt(2);
		//personagem.performStatus();
		
		System.out.println(personagem.getName());
	}

}