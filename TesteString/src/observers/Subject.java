package observers;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	
	public int getState(){
		return state;
	}
	
	//atualiza o estado e notifica aos observers
	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}
	
	//Adiciona um observer a lista de observers
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	//Remove um observer da lista de observers
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	//Atualiza todos os observers
	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
