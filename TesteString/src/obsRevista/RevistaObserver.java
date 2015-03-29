package obsRevista;

import java.util.Observable;

public class RevistaObserver extends Observable {
	private int edicao;

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
		
		setChanged();
		notifyObservers();
	}
	
	public static void main(String args[]){
		int novaEdicao = 3;
		RevistaObserver rev = new RevistaObserver();
		
		Assinante ass = new Assinante(rev);
		rev.setEdicao(novaEdicao);
		ass.notifyAll();//atoa
	}
}
