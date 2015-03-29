package rpg;

import java.util.Iterator;


public class dungeonsAndGambiarras {

	public static void main(String[] args) throws Exception {
		
		System.out.println("----------------------------------");
		System.out.println("Guerreiro:");
		System.out.println("----------------------------------");
		
		Personagem personagem2 = new Guerreiro();
		
		personagem2.setName("Fernando");
		System.out.println("Nome: "+personagem2.getName());
		
		System.out.println("Arma Primária:");
		personagem2.performWeapon();
		System.out.println("----------------------------------");
		
		System.out.println("Atributos:");
		System.out.println("----------------------------------");
		
		personagem2.performSetAttr("str",1);
		//System.out.println("Força: "+personagem2.performGetAttr("str"));
		
		personagem2.performSetAttr("destreza",3);
		//System.out.println("Destreza: "+personagem2.performGetAttr("destreza"));
		
		personagem2.performSetAttr("critical",0.1);
		//System.out.println("Critical chance: "+ personagem2.performGetAttr("critical"));
		
//		System.out.println("\n----------------------------------\n");
//		System.out.println("Nova classe:");
//		personagem2.setClasse(new Hunter());
//		personagem2.performClass();
		
		printAttr(personagem2);
		
		System.out.println("----------------------------------");
		System.out.println("Mago:");
		System.out.println("----------------------------------");
		
		Personagem personagem = new Mago();
		
		personagem.setName("Fernando");
		System.out.println("Nome: "+personagem2.getName());
		
		System.out.println("Arma Primária:");
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		System.out.println("Atributos:");
		System.out.println("----------------------------------");

		printAttr(personagem);
		
	}
	
	public static void printAttr(Personagem per){
		Iterator<AtributosBehavior<Object>> attrIT =  per.createIterator();
		printMenu(attrIT);
	}
	
	private static void printMenu(Iterator<AtributosBehavior<Object>> attrIT) {
		
		while (attrIT.hasNext()) {
			AtributosBehavior<Object> atributosBehavior = (AtributosBehavior<Object>) attrIT.next();
			System.out.println(atributosBehavior.getClass().getSimpleName()+": "+atributosBehavior.getAttr());
		}
	}

	
}
