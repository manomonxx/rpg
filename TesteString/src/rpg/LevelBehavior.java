package rpg;

public interface LevelBehavior {
	void levelUp(); //aumentar level do personagem
	//void setBonus(Integer str_, Integer agi_, Integer int_, Integer dex_); 
	
	void status();
	
	//distribui os pontos bônus - ordem str/agi/int/dex
	Boolean setStr_(Integer str_);
	Boolean setAgi_(Integer agi_);
	Boolean setInt_(Integer int_);
	Boolean setDex_(Integer dex_);
}
