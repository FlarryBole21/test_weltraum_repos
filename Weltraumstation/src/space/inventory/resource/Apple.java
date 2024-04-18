package space.inventory.resource;

public class Apple extends Fruit{

	public Apple(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Apfel");
	}

	@Override
	public void eat() {
		
	}

}
