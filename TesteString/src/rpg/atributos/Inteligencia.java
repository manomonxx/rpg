package rpg.atributos;

import rpg.AtributosBehavior;

public class Inteligencia implements AtributosBehavior<Object>{

	private Integer inteligencia;

	@Override
	public Integer getAttr() {
		return inteligencia;
	}

	@Override
	public void setAttr(Object value) {
		this.inteligencia = (Integer)value;
	}

}
