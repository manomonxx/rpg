package view;

import controller.InstanciaBanco;

public class mainSingleton {
	public static void main(String args[]) {
		InstanciaBanco singleton = new InstanciaBanco();
		
		singleton.Teste1();
		singleton.Teste2();
	}
}
