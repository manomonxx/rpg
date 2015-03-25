package rpg.atributos;

import rpg.Atributos;

public class Inteligencia implements Atributos<Object> {

	private Object inteligencia;
	
	@Override
	public Object getInteligencia() {
		return inteligencia;
	}

	@Override
	public void setInteligencia(Object inteligencia) {
		this.inteligencia = inteligencia;
	}

}
