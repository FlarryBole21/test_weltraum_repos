package space.inventory.resource;

public class Apple extends Fruit{

	private static final long serialVersionUID = 1L;

	public Apple(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Apfel");
	}

	@Override
	public void eat() {
		
	}

}
