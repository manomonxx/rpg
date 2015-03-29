package dinnerMenu.implementations;

import java.util.ArrayList;
import java.util.Iterator;

import dinnerMenu.MenuItem;
import dinnerMenu.interfaces.Menu;

public class PancakeHouseMenu implements Menu{

	private ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("caf�", "caf�", false, .80);
		addItem("caf� com leite", "caf� e leite", false, 1.0);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public Iterator<MenuItem> createIterator(){
		return menuItems.iterator();
	}
}
