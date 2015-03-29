package dinnerMenu.implementations;

import java.util.Iterator;

import dinnerMenu.MenuItem;
import dinnerMenu.interfaces.Menu;

public class DinnerMenu implements Menu{
	private static final int MAXITEMS = 6;
	private int numberofitems = 0;
	private MenuItem[] menuItems;
	
	public DinnerMenu() {
		menuItems = new MenuItem[MAXITEMS];
		addItem("padrão", "arroz com feijão", false, 5.80);
		addItem("especial", "arroz com feijão, bife e batata frita", false, 10.0);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		
		if(numberofitems >= MAXITEMS){
			System.err.println("Menu cheio!");
		}else {
			menuItems[numberofitems++] = menuItem;
		}
			
	}
	
	public Iterator<MenuItem> createIterator(){
		return new DinnerMenuIterator(menuItems);
	}
}
