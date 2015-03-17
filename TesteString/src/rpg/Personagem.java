package rpg;

public abstract class Personagem {

	public String name; // nome do personagem
	
	ClassBehavior classBehavior; // classe do personagem
	WeaponBehavior weaponBehavior; // arma utilizada pelo personagem
	LevelBehavior levelBehavior; //controla o nível e os atributos do personagem
	
	public Personagem() {
		
	} // construtor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void display(); // renderiza personagem

	public void performClass() {
		classBehavior.changeClass();
	}

	public void performWeapon() {
		weaponBehavior.useWeapon();
	}

	public void performLevel(){
		levelBehavior.levelUp();
	}
	
	public void performUpStr(Integer str_){
		levelBehavior.setStr_(str_);
	}
	
	public void performUpAgi(Integer agi_){
		levelBehavior.setAgi_(agi_);
	}
	
	public void performUpInt(Integer int_){
		levelBehavior.setInt_(int_);
	}
	
	public void performUpDex(Integer dex_){
		levelBehavior.setDex_(dex_);
	}
	
	public void performStatus(){
		levelBehavior.status();
	}
	
	public void setClasse(ClassBehavior cb) {
		classBehavior = cb; // redefine a classe do personagem
	}

	public void setWeapon(WeaponBehavior wb) {
		weaponBehavior = wb; // redefine a arma utilizada pelo personagem
	}
}
