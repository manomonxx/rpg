package rpg;

import rpg.weapons.Bow;


public class dungeonsAndGambiarras {

	public static void main(String[] args) {
		System.out.println("----------------------------------");
		System.out.println("Mago:");
		System.out.println("----------------------------------");
		Personagem<Integer> personagem = new Mago<Integer>();
		personagem.setName("Fernando");
		personagem.performClass();
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		
		personagem.performExpUp(2000); //2000 de exp
		
		personagem.performExpUp(70);
		
		//personagem.performLevel();
		//personagem.performLevel();
		personagem.performUpInt(4);
		//personagem.performStatus();
		
		System.out.println(personagem.getName());
		System.out.println(personagem.performStatus().get("int"));
		
		personagem.setWeapon(new Bow());
		personagem.performWeapon();
		
		
		System.out.println("----------------------------------");
		System.out.println("Guerreiro:");
		System.out.println("----------------------------------");
		Personagem<Integer> personagem2 = new Guerreiro<Integer>();
		personagem2.setName("Fernando");
		personagem2.performClass();
		personagem2.performWeapon();
		System.out.println("----------------------------------");
		
		personagem2.performSetAttr("forca",1);
		System.out.println("Força: "+personagem2.performGetAttr("forca"));
		
		personagem2.performSetAttr("destreza",3);
		System.out.println("Destreza: "+personagem2.performGetAttr("destreza"));
		
		personagem2.performSetAttr("inteligencia",6);
		System.out.println("Inteligência: "+personagem2.performGetAttr("inteligencia"));
	}

}
