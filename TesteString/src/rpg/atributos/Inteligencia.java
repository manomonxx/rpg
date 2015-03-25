package rpg.atributos;

import rpg.Atributos;

public class Inteligencia<E> implements Atributos<E>{

	private E inteligencia;

	@Override
	public E getAttr() {
		return inteligencia;
	}

	@Override
	public void setAttr(E value) {
		this.inteligencia = value;
	}

}
