package rpg;

import rpg.classes.Warrior;
import rpg.weapons.Sword;

public class Guerreiro extends Personagem{

	public Guerreiro() {
		classBehavior = new Warrior();
		weaponBehavior = new Sword();
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Guerreiro!");
	} //renderiza personagem

}
