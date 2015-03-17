package rpg;

public class LevelMago implements LevelBehavior {

	private final Integer param_bonus = 1; //pontuação bonus ganha a cada nível
	
	public Integer level = 1; // nível do personagem
	public long experience = 0; // experiencia do personagem

	private Integer str_ = 1; // força
	private Integer agi_ = 1; // agilidade

	private Integer int_ = 1; // inteligencia
	private Integer dex_ = 1; // destreza
	
	public Integer bonus = 0; //número total de pontos bonus disponiveis
	
	//crescimento str/agi/int/dex = 1/1/5/2 + bonus = 1 ponto/lvl
	@Override
	public void levelUp() {
		setLevel();
		str_ += 1;
		agi_ += 1;
		int_ += 5;
		dex_ += 2;
		
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Seu mago aumentou para o nível "+level);
		System.out.println("Seus novos status são:");
		System.out.println("------------------------");
		System.out.println("str: "+str_);
		System.out.println("agi: "+agi_);
		System.out.println("int: "+int_);
		System.out.println("dex: "+dex_);
		System.out.println("bonus: "+getBonus());
		System.out.println("------------------------");
		System.out.println();
		
	}//aumenta os atributos quando o personagem aumenta de nível

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

	private Integer getBonus() {
		return bonus;
	}

	private void setBonus() {
		this.bonus += param_bonus;
	}

	@Override
	public void status() {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Status: ");
		System.out.println("-------------------------");
		
		System.out.println("Level:"+ getLevel());
		System.out.println("str: "+str_);
		System.out.println("agi: "+agi_);
		System.out.println("int: "+int_);
		System.out.println("dex: "+dex_);
		System.out.println("bonus: "+getBonus());
		
		System.out.println("-------------------------");
		System.out.println();
	}	
}
