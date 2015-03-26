package rpg;

import java.util.HashMap;

import rpg.atributos.Destreza;
import rpg.atributos.Forca;
import rpg.atributos.Inteligencia;
import rpg.classes.Warrior;
import rpg.weapons.Sword;

public class Guerreiro<E> extends Personagem<E>{
	
	public Guerreiro() {
		classBehavior = new Warrior();
		weaponBehavior = new Sword();
		attrBehavior = new HashMap<String, AtributosBehavior<E>>();
		
		//agregando os atributos ao personagem
		attrBehavior.put("forca", new Forca<E>());
		attrBehavior.put("destreza", new Destreza<E>());
		attrBehavior.put("inteligencia", new Inteligencia<E>());
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Guerreiro!");
	} //renderiza personagem

}
