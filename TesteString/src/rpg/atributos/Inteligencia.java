package rpg.atributos;

import rpg.Atributos;

public class Inteligencia implements Atributos<Object> {

	private Object inteligencia;

	@Override
	public Object getAttr() {
		// TODO Auto-generated method stub
		return inteligencia;
	}

	@Override
	public void setAttr(Object value) {
		this.inteligencia = value;
	}

}
