package rpg;

import java.util.HashMap;
import java.util.Iterator;

import rpg.atributos.Destreza;
import rpg.atributos.Inteligencia;
import rpg.classes.Magician;
import rpg.weapons.Rod;

public class Mago extends Personagem{

	public Mago() {
		classBehavior = new Magician();
		weaponBehavior = new Rod();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("inteligencia", new Inteligencia(4));
		attrBehavior.put("destreza", new Destreza(3));
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking mago!");
	} //renderiza personagem

	@Override
	public Iterator<AtributosBehavior<Object>> createIterator() {
		if(attrBehavior == null)
			throw new NullPointerException("A classe AtributosBehavior não foi instânciada em "+ this.getClass().getSimpleName());
		
		return attrBehavior.values().iterator();
	}
}
