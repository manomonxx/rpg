package atributos;

import src.AtributosBehavior;

public class Inteligencia implements AtributosBehavior<Object>{

	private Integer inteligencia;

	public Inteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	@Override
	public Integer getAttr() {
		return inteligencia;
	}

	@Override
	public void setAttr(Object value) {
		this.inteligencia = (Integer)value;
	}

}
