package rpg;

import rpg.atributos.Inteligencia;

public class AttrMago<E> extends Status<E> {
	
	public AttrMago() {
		inteligencia = new Inteligencia<E>();
	}
	
	@Override
	public void setStatus() {
		System.out.println("AttrMago!");
	}	
}
