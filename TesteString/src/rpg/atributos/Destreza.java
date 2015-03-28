package rpg.atributos;

import rpg.AtributosBehavior;

public class Destreza implements AtributosBehavior<Object> {

	private Integer destreza; //atributo destreza.
	
	public Destreza(Integer destreza) {
		this.destreza = destreza;
	}
	
	@Override
	public Integer getAttr() {
		return this.destreza;
	}

	@Override
	public void setAttr(Object value) {
		this.destreza = (Integer)value;
	}

}
