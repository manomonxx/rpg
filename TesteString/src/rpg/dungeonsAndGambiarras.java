package rpg;


public class dungeonsAndGambiarras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------");
		System.out.println("Mago:");
		System.out.println("----------------------------------");
		Personagem personagem = new Mago();
		personagem.setName("Fernando");
		personagem.performClass();
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		personagem.performLevel();
		personagem.performLevel();
		personagem.performUpInt(2);
		personagem.performStatus();
		
	}

}
