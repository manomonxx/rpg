package src;

import classes.Arqueiro;
import classes.Mago;

public class MainSkillTeste {

	public static void main(String[] args) {
		
		Personagem personagem = new Mago();
		
		personagem.setName("Fernando");
		System.out.println("Nome: "+personagem.getName());
		
		System.out.println("Arma Primária:");
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		System.out.println("Habilidades:");
		System.out.println("----------------------------------");
		
		personagem.printSkillTree(); //imprime a árvore de habilidades do personagem
		
		Personagem personagem2 = new Arqueiro();
		
		personagem2.setName("Manomonxx");
		System.out.println("Nome: "+personagem2.getName());
		
		System.out.println("Arma Primária:");
		personagem2.performWeapon();
		System.out.println("----------------------------------");
		
		System.out.println("Habilidades:");
		System.out.println("----------------------------------");
			
		personagem2.printSkillTree();
	}

}
