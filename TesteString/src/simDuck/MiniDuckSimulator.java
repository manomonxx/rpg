package simDuck;

public class MiniDuckSimulator {

	public static void main(String[] args){
		
		System.out.println("----------------------------------");
		System.out.println("Mallard Duck:");
		System.out.println("----------------------------------");
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		System.out.println("----------------------------------");
		
		System.out.println();
		
		System.out.println("----------------------------------");
		System.out.println("Model Duck:");
		System.out.println("----------------------------------");
		Duck model = new ModelDuck();
		model.performQuack();
		model.performFly();
		System.out.println("----------------------------------");
		
		
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
