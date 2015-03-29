package rpg.atributos;

import rpg.AtributosBehavior;

public class Forca implements AtributosBehavior<Object> {

	private Integer forca; //atributo força.

	public Forca(Integer forca) {
		this.forca = forca;
	}
	
	@Override
	public Integer getAttr() {
		return this.forca;
	}

	@Override
	public void setAttr(Object value) {
		this.forca = (Integer)value;
	}

}
