package simDuck;

public class ModelDuck extends Duck{

	public ModelDuck() {
		// TODO Auto-generated constructor stub
		quackbehavior = new Quack();
		flybehavior = new FlyNoWay();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Im a model Duck!");
	}	
}
