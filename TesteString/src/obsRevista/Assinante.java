package obsRevista;

import java.util.Observable;
import java.util.Observer;

public class Assinante implements Observer{

	Observable revistaObserver;
	int edicaoNovaRevista;
	
	public Assinante(Observable revista){
		this.revistaObserver = revista;
		revistaObserver.addObserver(this);
	}
	
	@Override
	public void update(Observable revistaSubject, Object arg1) {
		// TODO Auto-generated method stub
		if(revistaSubject instanceof RevistaObserver){
			RevistaObserver revInfo = (RevistaObserver) revistaSubject;
			edicaoNovaRevista = revInfo.getEdicao();
			System.out.println("Atenção, já chegou a mais uma edição da Revista Informatica. " + "Esta é a sua edição número: " + edicaoNovaRevista);
		}
	}

}
