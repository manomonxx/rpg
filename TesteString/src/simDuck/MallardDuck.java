package simDuck;

public class MallardDuck extends Duck {

	public MallardDuck() {
		// TODO Auto-generated constructor stub
		quackbehavior = new Quack();
		flybehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Im real mallad duck!");
	}

	
}
