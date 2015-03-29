package dinnerMenu;

import dinnerMenu.implementations.CafeMenu;
import dinnerMenu.implementations.DinnerMenu;
import dinnerMenu.implementations.PancakeHouseMenu;
import dinnerMenu.interfaces.Menu;

public class MenuTestDrive {

	public static void main(String[] args) {
		Menu pancake = new PancakeHouseMenu();
		Menu dinner = new DinnerMenu();
		Menu cafe = new CafeMenu();
		
		Waitress controller = new Waitress(pancake, dinner, cafe);
		
		controller.printMenu();
	}

}
