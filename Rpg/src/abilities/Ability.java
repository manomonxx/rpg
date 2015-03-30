package abilities;

import java.util.Map;

import src.AbilityComponent;
import status.Status;
import utilities.TypeRange;

public class Ability extends AbilityComponent{

	private String name; //nome da habilidade
	private Integer level_; //nível da habilidade - número de pontos ditribuídos nela
	private TypeRange range; //área de efeito da habilidade
	private String description; //descrição da habilidade
	private Map<String, Status> status; //map de status ligados a habilidade(Stun, Slow etc...)
	
	public Ability(String name, Integer level, TypeRange range, String description, Map<String, Status> status) {
		this.name = name;
		this.level_ = level;
		this.range = range;
		this.description = description;
		this.status = status; //se não houver status agregado a esta habilidade seu valor será nulo.
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel_() {
		return level_;
	}

	public void setLevel_(Integer level_) {
		this.level_ = level_;
	}

	public TypeRange getRange() {
		return range;
	}

	public void setRange(TypeRange range) {
		this.range = range;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Status> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Status> status) {
		this.status = status;
	}
	
	public void print(){
		
		//Imprimindo atributos de uma habilidade
		System.out.println("--------------------------------");
		System.out.println(getName());
		System.out.println("--------------------------------");
		System.out.println(getLevel_());
		System.out.println(getDescription());
		
		System.out.println(getRange().toString());
		System.out.println(getStatus().toString());
		System.out.println("--------------------------------\n");
	}
}
