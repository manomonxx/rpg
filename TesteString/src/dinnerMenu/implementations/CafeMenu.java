package dinnerMenu.implementations;

import java.util.Hashtable;
import java.util.Iterator;

import dinnerMenu.MenuItem;
import dinnerMenu.interfaces.Menu;

public class CafeMenu implements Menu {

	Hashtable<String, MenuItem> menuItems;
	
	public CafeMenu() {
		menuItems = new Hashtable<String, MenuItem>();
		
		addItem("expresso", "café expresso", false, .80);
		addItem("capputino", "café capputino", false, 2.50);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		
		menuItems.put(name, menuItem);
	}
	
	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}

}
