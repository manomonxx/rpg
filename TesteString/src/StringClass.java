
public class StringClass {

	public static void main(String[] args) {
		
		String texto = "Anderson Weslley Curcio Pacheco	";
		String padrao = "Curcio";
		
		char padraocurrent = padrao.charAt(0);
		
		for (int i = 0; i < texto.length(); i++) {
			
			//se o primeiro caracter do padr�o for encontrado
			if(texto.charAt(i) == padraocurrent){
				for (int j = 1; j < padrao.length(); j++) {
					
					//percorre o texto procurando algum caracter diferente do padr�o
					if(texto.charAt(++i) != padrao.charAt(j)){
						break;
					}
					
					//executa se o padr�o foi encontrado e retorna sua posi��o inicial
					if((j+1) == padrao.length()){
						System.out.println("Achou! pos:"+(i-j));
					}
				}
			}
		}
		
	}

}
