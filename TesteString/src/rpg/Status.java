package rpg;

public interface Status {
	final Integer param_bonus = 1; //pontua��o bonus ganha a cada n�vel
	
	Integer getLevel();
	void setLevel();
	Integer getStr_();
	Boolean setStr_(Integer str_) ;
	Integer getAgi_();
	Boolean setAgi_(Integer agi_);
	Integer getInt_();
	Boolean setInt_(Integer int_);
	Integer getDex_();
	Boolean setDex_(Integer dex_);
	Integer getBonus();
	void setBonus();
	void status();
}
