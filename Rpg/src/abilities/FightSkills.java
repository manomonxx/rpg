package abilities;

import java.util.Iterator;
import java.util.Map;

import status.Status;
import utilities.TypeRange;

public class FightSkills extends Ability{
	
	private Double damage; //dano da skill
	private String type; //tipo da skill (ranged/melee)
	private String element; //elemento da skill (Holy, Dark etc...)
	private Map<String, Status<?>> status; //map de status ligados a habilidade(Stun, Slow etc...)
	
	public FightSkills(String name, Integer level, TypeRange<?> range,
			Integer cooldown, Integer afterCastDelay, String description,
			Map<String, Status<?>> status, Double damage, String type,
			String element) {
		super(name, level, range, cooldown, afterCastDelay, description);
		this.damage = damage;
		this.type = type;
		this.element = element;
		this.status = status; //se não houver status agregado a esta habilidade seu valor será nulo.
	}
		
	public Double getDamage() {
		return damage;
	}


	public void setDamage(Double damage) {
		this.damage = damage;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getElement() {
		return element;
	}


	public void setElement(String element) {
		this.element = element;
	}
	
	public Map<String, Status<?>> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Status<?>> status) {
		this.status = status;
	}

	public void print(){
		
		//Imprimindo atributos de uma habilidade
		System.out.println("--------------------------------");
		System.out.println("Nome: "+getName());
		System.out.println("--------------------------------");
		System.out.println("Nível: "+getLevel_());
		System.out.println("Descrição: "+getDescription());
		
		System.out.println("Cooldown: "+getCast());
		System.out.println("Delay: "+getAfterCastDelay());
		System.out.println("Range: "+getAbilityRange().getRange());
		
		System.out.println("\nStatus:");
		
		Iterator<Status<?>> it = getStatus().values().iterator();
		while (it.hasNext()) {
			Status<?> status = (Status<?>) it.next();
			System.out.println("\nTipo: "+status.getClass().getSimpleName());
			System.out.println("Tempo: "+status.getStatusTime());
			System.out.println("Efeito: "+status.getEffect());
		}
		
		System.out.println("Damage: "+getDamage());
		System.out.println("Tipo: "+getType());
		System.out.println("Elemento: "+getElement());
		System.out.println("--------------------------------\n");
	}
}
