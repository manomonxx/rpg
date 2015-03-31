package src;

import java.util.Iterator;
import java.util.Map;

import javax.activation.UnsupportedDataTypeException;

public abstract class Personagem {

	private String name; // nome do personagem
	
	protected ClassBehavior classBehavior; // classe do personagem
	protected WeaponBehavior weaponBehavior; // arma utilizada pelo personagem
	protected Map<String, AtributosBehavior<Object>> attrBehavior; //controla os atributos do personagem
	
	protected AbilityComponent allAbilities; //árvore de habilidades do personagem
	
	public Personagem() {
		
	} // construtor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Iterator<AtributosBehavior<Object>> createIterator(); // renderiza personagem

	public abstract void display(); // renderiza personagem

	public abstract void printSkillTree(); //imprime a árvore de habilidades
	
	public void performSetAttr(String name, Object value) throws Exception {
		AtributosBehavior<Object> aux =  attrBehavior.get(name);
		
		if(aux == null){
			throw new NullPointerException("A classe de nickname \""+name+"\" não foi instânciada!");
		}
		
		//Compara o tipo instânciado(Main) com o tipo da Classe(Atributo)
		if(aux.getAttr().getClass().getName().equals(value.getClass().getName())){
			aux.setAttr(value);
		}else{
			throw new UnsupportedDataTypeException("Tipo "+value.getClass().getSimpleName()+" incompatível com o tipo da classe "+attrBehavior.get(name).getClass().getSimpleName()+"("+aux.getAttr().getClass().getSimpleName()+")");
		}
	}
	
	public Object performGetAttr(String name) {
		if(attrBehavior.get(name) == null){
			throw new NullPointerException("A classe de nickname \""+name+"\" não foi instânciada!");
		}
		
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
