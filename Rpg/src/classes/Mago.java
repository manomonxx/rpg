package classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import src.AbilityComponent;
import src.AtributosBehavior;
import src.Personagem;
import status.Slow;
import status.Status;
import status.Stun;
import utilities.RangeSkills;
import utilities.TypeRange;
import weapons.Rod;
import abilities.FightSkills;
import abilities.ProfessionSkills;
import abilities.SkillTree;
import atributos.Destreza;
import atributos.Inteligencia;

//Classe Prim�ria
public class Mago extends Personagem{
	
	public Mago() {
		classBehavior = new Magician();
		weaponBehavior = new Rod();
		
		//atributos
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		attrBehavior.put("inteligencia", new Inteligencia(4));
		attrBehavior.put("destreza", new Destreza(3));
		
		//habilidades
		allAbilities = new SkillTree("Mago", "Habilidades da Classe Mago");
		Map<String, Status<?>> allStatus = new HashMap<String, Status<?>>();
		TypeRange<Double> range = new RangeSkills<Double>(10.0);
		
		//adicionando status � habilidade
		allStatus.put("Stun", new Stun(1.2, true)); //tempo em segundos e habilita/desabilita a��o.
		allStatus.put("slow", new Slow(1.2, .3)); //tempo e porcentagem de slow
		
		allAbilities.addAbility(new FightSkills("Increase Spiritual Power", 1, range, 2.6, 3.4, "Recovers (Maximum SP/500 + 3)*SkillLV SP per 10 full seconds when standing still and increases the efficiency of SP recovering items by +2% per SkillLV.", allStatus, null, "Passive", null));
		allAbilities.addAbility(new ProfessionSkills("Craft", 10, range, 4.0, 3.9, "Constr�i armaduras!"));
		
	}
	
	public Mago(AbilityComponent abilities) {
		classBehavior = new Magician();
		weaponBehavior = new Rod();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("inteligencia", new Inteligencia(4));
		attrBehavior.put("destreza", new Destreza(3));
		
		allAbilities = abilities;
	}
	
	@Override
	public void display() {
		System.out.println("Eu sou 1 fucking mago!");
	} //renderiza personagem

	@Override
	public Iterator<AtributosBehavior<Object>> createIterator() {
		if(attrBehavior == null)
			throw new NullPointerException("A classe AtributosBehavior n�o foi inst�nciada em "+ this.getClass().getSimpleName());
		
		return attrBehavior.values().iterator();
	}
	
	@Override
	public void printSkillTree(){
		allAbilities.print();
	}
}
