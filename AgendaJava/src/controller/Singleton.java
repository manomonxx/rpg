package controller;

public class Singleton {
	private static Singleton instance;
	
	private Singleton(){
	}
	
	public static synchronized Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		
		return instance;
	}
	
	//---------------------------------------------------
	// M�todos da classe
	//---------------------------------------------------
	public static String Teste(){
		return "Deu certo!";
	}
	//---------------------------------------------------

}
