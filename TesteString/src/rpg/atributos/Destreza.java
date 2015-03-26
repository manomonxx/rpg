package rpg.atributos;

import rpg.AtributosBehavior;

public class Destreza<E> implements AtributosBehavior<E> {

	private E destreza; //atributo destreza.
	
	@Override
	public E getAttr() {
		return this.destreza;
	}

	@Override
	public void setAttr(E value) {
		this.destreza = value;
	}

}
