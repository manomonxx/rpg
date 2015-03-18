package rpg;

public class StatusMago implements Status {
	
	Integer level = 1; // nível do personagem
	long experience = 0; // experiencia do personagem

	Integer str_ = 1; // força
	Integer agi_ = 1; // agilidade

	Integer int_ = 1; // inteligencia
	Integer dex_ = 1; // destreza
	
	Integer bonus = 0; //número total de pontos bonus disponiveis
	
	public StatusMago() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Integer getLevel(){
		return this.level;
	}
	
	@Override
	public void setLevel(){
		level++;
		setBonus();
	}
	
	@Override
	public Integer getStr_() {
		return str_;
	}

	@Override
	public Boolean setStr_(Integer str_) {
		if(this.bonus > 0 && this.bonus >= str_){
			this.str_ += str_;
			this.bonus -= str_;
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public Integer getAgi_() {
		return agi_;
	}

	@Override
	public Boolean setAgi_(Integer agi_) {
		if(this.bonus > 0 && this.bonus >= agi_){
			this.agi_ += agi_;
			this.bonus -= agi_;
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public Integer getInt_() {
		return int_;
	}

	@Override
	public Boolean setInt_(Integer int_) {
		if(this.bonus > 0 && this.bonus >= int_){
			this.int_ += int_;
			this.bonus -= int_;
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public Integer getDex_() {
		return dex_;
	}

	@Override
	public Boolean setDex_(Integer dex_) {
		if(this.bonus > 0 && this.bonus >= dex_){
			this.dex_ += dex_;
			this.bonus -= dex_;
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public Integer getBonus() {
		return bonus;
	}

	@Override
	public void setBonus() {
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
