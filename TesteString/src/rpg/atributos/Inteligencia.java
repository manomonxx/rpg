package rpg.atributos;

import rpg.Atributos;

public class Inteligencia implements Atributos<Object> {

	private Object inteligencia;

	@Override
	public Object getAttr() {
		return inteligencia;
	}

	@Override
	public void setAttr(Object value) {
		this.inteligencia = value;
	}

}
