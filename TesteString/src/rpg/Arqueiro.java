package rpg;

import java.util.HashMap;
import java.util.Iterator;

import rpg.atributos.CriticalChance;
import rpg.atributos.Destreza;
import rpg.atributos.Forca;
import rpg.classes.Hunter;
import rpg.weapons.Bow;

public class Arqueiro extends Personagem{

	public Arqueiro() {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("critical", new CriticalChance(.2));
		attrBehavior.put("destreza", new Destreza(3));
		attrBehavior.put("str", new Forca(2));
		
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking Arqueiro!");
	} //renderiza personagem
	
	@Override
	public Iterator<AtributosBehavior<Object>> createIterator() {
		if(attrBehavior == null)
			throw new NullPointerException("A classe AtributosBehavior não foi instânciada em "+ this.getClass().getSimpleName());
		
		return attrBehavior.values().iterator();
	}

}
