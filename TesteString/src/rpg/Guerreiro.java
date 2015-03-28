package rpg;

import java.util.HashMap;

import rpg.atributos.CriticalChance;
import rpg.atributos.Forca;
import rpg.classes.Warrior;
import rpg.weapons.Sword;

public class Guerreiro extends Personagem{
	
	public Guerreiro() {
		classBehavior = new Warrior(); //TODO depois extender exemplo com mais classes - skyrim =[
		weaponBehavior = new Sword(); //TODO depois extender exemplo com mais armas - Bárbaro com 2 machados
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		
		//agregando os atributos ao personagem
		attrBehavior.put("forca", new Forca(1));
		//attrBehavior.put("destreza", new Destreza<E>());
		//attrBehavior.put("inteligencia", new Inteligencia<E>());
		attrBehavior.put("critical", new CriticalChance(.1));
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Guerreiro!");
	} //renderiza personagem

}
