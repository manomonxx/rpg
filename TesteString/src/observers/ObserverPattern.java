package observers;

public class ObserverPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		
		BinaryObserver bin = new BinaryObserver(subject);
		new OctalObserver(subject);
		new HexaObserver(subject);
		
		System.out.println("Para 10");
		subject.setState(10);
		
		System.out.println("Para 20");
		subject.setState(20);
		
		//removendo 1 observer ...
		subject.detach(bin); //BinaryObserver
		System.out.println("Para 30");
		subject.setState(30);
		
	}

}
