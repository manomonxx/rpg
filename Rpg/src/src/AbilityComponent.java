package src;

import java.util.Map;

import status.Status;
import utilities.TypeRange;

public abstract class AbilityComponent {
	
	public void addAbility(AbilityComponent abilityComponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove(AbilityComponent abilityComponent){
		throw new UnsupportedOperationException();
	}
	
	public AbilityComponent getChild(int i){
		throw new UnsupportedOperationException();
	}
	
	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	public Integer getLevel_() {
		throw new UnsupportedOperationException();
	}
	
	public TypeRange getRange() {
		throw new UnsupportedOperationException();
	}
	
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	
	public Map<String, Status> getStatus() {
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}
	
}
