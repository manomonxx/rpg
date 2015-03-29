package dinnerMenu;

import java.util.Iterator;

import dinnerMenu.interfaces.Menu;

public class Waitress {
	
	Menu pancakehousemenu;
	Menu dinnermenu;
	Menu cafemenu;
	
	public Waitress(Menu pancakehousemenu, Menu dinnermenu, Menu cafemenu) {
		this.pancakehousemenu = pancakehousemenu;
		this.dinnermenu = dinnermenu;
		this.cafemenu = cafemenu;
	}
	
	public void printMenu(){
		Iterator<MenuItem> pancakeIterator = pancakehousemenu.createIterator();
		Iterator<MenuItem> dinneIterator = dinnermenu.createIterator();
		Iterator<MenuItem> cafeIterator = cafemenu.createIterator();
		
		System.out.println("Menu\n-----------\nBreakfast");
		printMenu(pancakeIterator);
		
		System.out.println("\nLunch");
		printMenu(dinneIterator);

		System.out.println("\nCafé");
		printMenu(cafeIterator);
	}
	
	private void printMenu(Iterator<MenuItem> iterator){
		while (iterator.hasNext()) {
			MenuItem menuitem = (MenuItem) iterator.next();
			System.out.println("Nome: "+menuitem.getName());
			System.out.println("Descrição: "+menuitem.getDescription());
			System.out.println("Preço: 	"+menuitem.getPrice());
		}
	}
}
