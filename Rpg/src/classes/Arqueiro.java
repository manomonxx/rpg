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
import weapons.Bow;
import abilities.FightSkills;
import abilities.ProfessionSkills;
import abilities.SkillTree;
import atributos.CriticalChance;
import atributos.Destreza;
import atributos.Forca;

//Classe Primária
public class Arqueiro extends Personagem{

	public Arqueiro() {
		classBehavior = new Hunter();
		weaponBehavior = new Bow();
		attrBehavior = new HashMap<String, AtributosBehavior<Object>>();
		
		attrBehavior.put("critical", new CriticalChance(.2));
		attrBehavior.put("destreza", new Destreza(3));
		attrBehavior.put("str", new Forca(2));
		
		allAbilities = new SkillTree("Arqueiro", "Skills do Arqueiro!");
		
		Map<String, Status<?>> allStatus = new HashMap<String, Status<?>>();
		TypeRange<Double> range = new RangeSkills<Double>(10.0);
		
		//adicionando status à habilidade
		allStatus.put("Stun", new Stun(1.2, true)); //tempo em segundos e habilita/desabilita ação.
		allStatus.put("slow", new Slow(1.2, .3)); //tempo e porcentagem de slow
		
		allAbilities.addAbility(new FightSkills("Vulture's Eye", 1, range, 2.1, 3.1, "Increases range with bows by 1*SkillLV cells and increases HIT by 1 per SkillLV.", allStatus, null, "Passive", "Fire"));
		allAbilities.addAbility(new ProfessionSkills("Craft", 10, range, 4.2, 3.3, "Constrói armaduras!"));
	}
	
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
