package dinnerMenu;

public abstract class MenuComponent {

	public void add(){
		throw new UnsupportedOperationException();
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	public MenuComponent getChild(int id){
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		throw new UnsupportedOperationException();
	}
	
	public String getDescription(){
		throw new UnsupportedOperationException();
	}
	
	public double getPrice(){
		throw new UnsupportedOperationException();
	}
	
	public boolean isVegetarian(){
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}
}
