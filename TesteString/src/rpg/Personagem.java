package rpg;

import java.util.Map;

public abstract class Personagem {

	private String name; // nome do personagem
	
	ClassBehavior classBehavior; // classe do personagem
	WeaponBehavior weaponBehavior; // arma utilizada pelo personagem
	LevelBehavior levelBehavior; //controla o nível e os atributos do personagem
	Map<String, AtributosBehavior<Object>> attrBehavior; //controla o nível e os atributos do personagem
	
	public Personagem() {
		
	} // construtor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void display(); // renderiza personagem
	
	public void performSetAttr(String name, Object value) {
		AtributosBehavior<Object> aux =  attrBehavior.get(name);
		aux.setAttr(value);
	}
	
	public Object performGetAttr(String name) {
		return attrBehavior.get(name).getAttr();
	}
	
	public void performClass() {
		classBehavior.changeClass();
	}

	public void performWeapon() {
		weaponBehavior.useWeapon();
	}
	
	public void setClasse(ClassBehavior cb) {
		classBehavior = cb; // redefine a classe do personagem
	}

	public void setWeapon(WeaponBehavior wb) {
		weaponBehavior = wb; // redefine a arma utilizada pelo personagem
	}
}
