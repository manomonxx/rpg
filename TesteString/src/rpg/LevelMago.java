package rpg;

import java.util.HashMap;
import java.util.Map;


public class LevelMago implements LevelBehavior {

	private final Integer param_bonus = 1; //pontuação bonus ganha a cada nível
	private final Integer taxHp = 10; //cada ponto de vit corresponde a 10 pontos e hp - varia com a classe
	private final Integer taxMp = 5; //cada ponto de int corresponde a 10 pontos e hp - varia com a classe
	
	private final Integer hpIni = 100;
	private final Integer mpIni = 100;
	
	public Integer level = 1; // nível do personagem
	public Long experience = (long) 0; // experiencia do personagem

	private Integer hp_ = hpIni; //hp inicial - varia com a classe
	private Integer mp_ = mpIni; //mp inicial - varia com a classe
	
	private Integer str_ = 1; // força
	private Integer agi_ = 1; // agilidade
	private Integer int_ = 1; // inteligencia
	private Integer dex_ = 1; // destreza
	private Integer vit_ = 1; // força
	
	public Integer bonus = 0; //número total de pontos bonus disponiveis
	
	Map<String, String> status = new HashMap<String, String>();
	
	//crescimento str/agi/int/dex = 1/1/5/2 + bonus = 1 ponto/lvl
	private void levelUp() {
		setLevel();
		str_ += 1;
		agi_ += 1;
		int_ += 5;
		dex_ += 2;
		vit_ += 1;
		
		setHp_();
		setMp_();
		
		status(); //att a hash de status
		printStatus(); //imprime o status
		
	}//aumenta os atributos quando o personagem aumenta de nível	
	
	private long attFormula(){
		return (long) Math.pow(2, this.level); //total de exp para aumentar de level
	}
	
	public long getExperience() { //exp atual 
		return experience;
	}

	public void setExperience(long experience) {
		this.experience += experience;
		
		checkLevel();
	}
	
	public void checkLevel(){
		if(this.experience >= attFormula()){
			levelUp();
			checkLevel(); //recursivo para permitir o aumento de mais de 1 level de uma vez
		}
	}
	
	protected Integer getLevel(){
		return this.level;
	}
	
	private void setLevel(){
		this.level++;
		setBonus();
	}
	
	protected Integer getStr_() {
		return str_;
	}

	public Boolean setStr_(Integer str_) {
		if(this.bonus > 0 && this.bonus >= str_){
			this.str_ += str_;
			this.bonus -= str_;
		}else{
			return false;
		}
		
		return true;
	}

	protected Integer getAgi_() {
		return agi_;
	}

	public Boolean setAgi_(Integer agi_) {
		if(this.bonus > 0 && this.bonus >= agi_){
			this.agi_ += agi_;
			this.bonus -= agi_;
		}else{
			return false;
		}
		
		return true;
	}

	protected Integer getInt_() {
		return int_;
	}

	public Boolean setInt_(Integer int_) {
		if(this.bonus > 0 && this.bonus >= int_){
			this.int_ += int_;
			this.bonus -= int_;
		}else{
			return false;
		}
		
		return true;
	}

	protected Integer getDex_() {
		return dex_;
	}

	public Boolean setDex_(Integer dex_) {
		if(this.bonus > 0 && this.bonus >= dex_){
			this.dex_ += dex_;
			this.bonus -= dex_;
		}else{
			return false;
		}
		
		return true;
	}

	public Integer getHp_() {
		return hp_;
	}

	private void setHp_() {
		double r = Math.pow((this.hp_/hpIni)-1, 1/this.level);
		this.hp_ = (int) Math.round(this.hp_*r + this.vit_*taxHp);
	}

	public Integer getMp_() {
		return mp_;
	}

	private void setMp_() {
		double r = Math.pow((this.mp_/mpIni)-1, 1/this.level);
		this.mp_ = (int) Math.round(this.mp_*r + this.int_*taxMp);
	}

	protected Integer getVit_() {
		return vit_;
	}

	public Boolean setVit_(Integer vit_) {
		if(this.bonus > 0 && this.bonus >= vit_){
			this.vit_ += vit_;
			this.bonus -= vit_;
		}else{
			return false;
		}
		
		return true;
	}
	
	private Integer getBonus() {
		return bonus;
	}

	private void setBonus() {
		this.bonus += param_bonus;
	}

	@Override
	public Map<String, String> status() {
		
		Long expMax = (Long) attFormula();
		
		status.put("level",this.level.toString());
		status.put("str",this.str_.toString());
		status.put("agi",this.agi_.toString());
		status.put("int",this.int_.toString());
		status.put("dex",this.dex_.toString());
		status.put("vit",this.vit_.toString());
		status.put("bonus",getBonus().toString());
		status.put("exp", this.experience.toString());
		status.put("maxExp", expMax.toString());
		status.put("hp", this.hp_.toString());
		status.put("mp", this.mp_.toString());
		//printStatus();
		
		return status;
	}
	
	private void printStatus(){
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Status: ");
		System.out.println("-------------------------");
		
		System.out.println("Level:"+ status.get("level"));
		System.out.println("HP: "+status.get("hp"));
		System.out.println("MP: "+status.get("mp"));
		System.out.println("str: "+status.get("str"));
		System.out.println("agi: "+status.get("agi"));
		System.out.println("int: "+status.get("int"));
		System.out.println("dex: "+status.get("dex"));
		System.out.println("vit: "+status.get("vit"));
		System.out.println("bonus: "+status.get("bonus"));
		System.out.println("exp: "+status.get("exp"));
		System.out.println("next level: "+status.get("maxExp"));
		
		System.out.println("-------------------------");
		System.out.println();
	}
}
