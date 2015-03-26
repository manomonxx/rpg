package rpg.atributos;

import rpg.AtributosBehavior;

public class Forca<E> implements AtributosBehavior<E> {

	private E forca; //atributo for�a.
	
	@Override
	public E getAttr() {
		return this.forca;
	}

	@Override
	public void setAttr(E value) {
		this.forca = value;
	}

}
