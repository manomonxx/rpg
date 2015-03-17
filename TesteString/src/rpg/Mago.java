package rpg;

import rpg.classes.Magician;
import rpg.weapons.Rod;

public class Mago extends Personagem{

	public Mago() {
		classBehavior = new Magician();
		weaponBehavior = new Rod();
		levelBehavior = new LevelMago();
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking mago!");
	} //renderiza personagem

}
