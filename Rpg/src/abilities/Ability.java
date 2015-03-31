package abilities;

import src.AbilityComponent;
import utilities.TypeRange;

public class Ability extends AbilityComponent{

	private String name; //nome da habilidade
	private Integer level_; //nível da habilidade - número de pontos ditribuídos nela
	private TypeRange<?> range; //área de efeito da habilidade
	private Integer cast; //tempo de execução da Habilidade
	private Integer afterCastDelay; //tempo de espera entre Habilidades
	
	public Integer getCast() {
		return cast;
	}

	public void setCast(Integer castTime) {
		this.cast = castTime;
	}

	public Integer getAfterCastDelay() {
		return afterCastDelay;
	}

	public void setAfterCastDelay(Integer afterCastDelay) {
		this.afterCastDelay = afterCastDelay;
	}

	private String description; //descrição da habilidade
	
	
	public Ability(String name, Integer level, TypeRange<?> range,Integer cooldown, Integer afterCastDelay, String description) {
		this.name = name;
		this.level_ = level;
		this.range = range;
		this.cast = cooldown;
		this.afterCastDelay = afterCastDelay;
		this.description = description;
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

	public TypeRange<?> getAbilityRange() {
		return range;
	}

	public void setAbilityRange(TypeRange<?> range) {
		this.range = range;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		
		System.out.println("--------------------------------\n");
	}
}
