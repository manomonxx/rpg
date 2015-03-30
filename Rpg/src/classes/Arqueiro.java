package classes;

import java.util.HashMap;
import java.util.Iterator;

import src.AbilityComponent;
import src.AtributosBehavior;
import src.Personagem;
import weapons.Bow;
import atributos.CriticalChance;
import atributos.Destreza;
import atributos.Forca;

//Classe Primária
public class Arqueiro extends Personagem{

	public Arqueiro(AbilityComponent abilities) {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("critical", new CriticalChance(.2));
		attrBehavior.put("destreza", new Destreza(3));
		attrBehavior.put("str", new Forca(2));
		
		allAbilities = abilities;
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

	@Override
	public void printSkillTree() {
		allAbilities.print();
	}

}
