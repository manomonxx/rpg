package rpg;

import java.util.HashMap;

import rpg.atributos.CriticalChance;
import rpg.atributos.Forca;
import rpg.classes.Hunter;
import rpg.weapons.Bow;

public class Arqueiro extends Personagem{

	public Arqueiro() {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("critical", new CriticalChance(1.0));
		attrBehavior.put("str", new Forca(1));
		
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Arqueiro!");
	} //renderiza personagem

}
