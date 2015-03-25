package rpg;

import rpg.atributos.Inteligencia;

public abstract class Status<E> {
	Inteligencia<E> inteligencia;
	
	abstract void setStatus();
	
	public void performSetStatus(E value){
		inteligencia.setAttr(value);
	}
	
	public Object performGetStatus(){
		return inteligencia.getAttr();
	}
}  