package controller;


//Exemplo Singleton - Para entender como funciona
public final class InstanciaBanco {

	//atributos que não serão vistos fora da classe
	private static final InstanciaBanco INSTANCE = new InstanciaBanco();
	
	//atributos que podem ser vistos fora deste escopo
	public static final String Singleton = "Teste";
		
	//método construtor
	public InstanciaBanco(){
		
	}
	
	//retorna a instância da classe
	public static InstanciaBanco getInstance(){
		return INSTANCE;
	}
	
	//----------------------------------------------
	//métodos que podem ser acessados fora do escopo
	//----------------------------------------------
	public static void Teste1(){
		System.out.println("teste1");
	}
	
	public static void Teste2(){
		System.out.println("teste2");
	}
	//----------------------------------------------
}
