package rpg;

import rpg.classes.Hunter;
import rpg.weapons.Bow;

public class Arqueiro<E> extends Personagem<E>{

	public Arqueiro() {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Arqueiro!");
	} //renderiza personagem

}
