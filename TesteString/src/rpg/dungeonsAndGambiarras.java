package rpg;

public class dungeonsAndGambiarras {

	public static void main(String[] args) {
		
		System.out.println("----------------------------------");
		System.out.println("Guerreiro:");
		System.out.println("----------------------------------");
		Personagem personagem2 = new Guerreiro();
		personagem2.setName("Fernando");
		personagem2.performClass();
		personagem2.performWeapon();
		System.out.println("----------------------------------");
		
		personagem2.performSetAttr("forca",1);
		System.out.println("Força: "+personagem2.performGetAttr("forca"));
		
//		personagem2.performSetAttr("destreza",3);
//		System.out.println("Destreza: "+personagem2.performGetAttr("destreza"));
//		
//		personagem2.performSetAttr("inteligencia",6);
//		System.out.println("Inteligência: "+personagem2.performGetAttr("inteligencia"));
		
		personagem2.performSetAttr("critical",0.1);
		System.out.println("Critical chance: "+ personagem2.performGetAttr("critical"));
	}

}
