package view;

import controller.InstanciaBanco;
import controller.Singleton;

public class mainSingleton {
	public static void main(String args[]) {
		InstanciaBanco singleton = new InstanciaBanco();
		
		singleton.Teste1();
		singleton.Teste2();
		
		
		//Singleton.getInstance();
		String Sinstance = Singleton.Teste();
		
		System.out.println(Sinstance);
	}
}
