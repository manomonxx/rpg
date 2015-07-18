package abilities;

import java.util.ArrayList;
import java.util.Iterator;

import src.AbilityComponent;

public class SkillTree extends AbilityComponent{
	//lista de habilidades
	ArrayList<AbilityComponent> abilityComponent = new ArrayList<AbilityComponent>(); 
	
	private String name;
	private String description;
	
	public SkillTree(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void addAbility(AbilityComponent skill){
		abilityComponent.add(skill); //adiciona uma skill a árvore de habilidades
	}
	
	public void remove(AbilityComponent skill){
		abilityComponent.remove(skill);
	}
	
	public AbilityComponent getChild(int index){
		return (AbilityComponent) abilityComponent.get(index);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void print(){
		System.out.println("------------------------");
		System.out.println(getName());
		System.out.println(getDescription());
		System.out.println("------------------------\n");
		
		Iterator<AbilityComponent> iterator = abilityComponent.iterator();
		while (iterator.hasNext()) {
			AbilityComponent abilityComponent = (AbilityComponent) iterator
					.next();
			abilityComponent.print(); //imprime os valores dos filhos
		}
	}
}
