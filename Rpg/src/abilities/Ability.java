package abilities;

import src.AbilityComponent;
import utilities.TypeRange;

public class Ability extends AbilityComponent{

	private String name; //nome da habilidade
	private Integer level_; //nível da habilidade - número de pontos ditribuídos nela
	private TypeRange<?> range; //área de efeito da habilidade
	private Double cast; //tempo de execução da Habilidade
	private Double afterCastDelay; //tempo de espera entre Habilidades
	
	public Double getCast() {
		return cast;
	}

	public void setCast(Double castTime) {
		this.cast = castTime;
	}

	public Double getAfterCastDelay() {
		return afterCastDelay;
	}

	public void setAfterCastDelay(Double afterCastDelay) {
		this.afterCastDelay = afterCastDelay;
	}

	private String description; //descrição da habilidade
	
	
	public Ability(String name, Integer level, TypeRange<?> range,Double castTime, Double afterCastDelay, String description) {
		this.name = name;
		this.level_ = level;
		this.range = range;
		this.cast = castTime;
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
