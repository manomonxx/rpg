package rpg;

import rpg.classes.Hunter;
import rpg.weapons.Bow;

public class Arqueiro extends Personagem{

	public Arqueiro() {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Arqueiro!");
	} //renderiza personagem

}
