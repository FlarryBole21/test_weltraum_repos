package space.inventory.resource;

public class Apple extends Fruit{

	public Apple(int requiredLevel) {
		super(requiredLevel);
		super.setType("Apfel");
	}

	@Override
	public void eat() {
		
	}

}
