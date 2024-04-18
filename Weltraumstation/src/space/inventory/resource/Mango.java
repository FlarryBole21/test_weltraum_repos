package space.inventory.resource;

public class Mango extends Fruit {

	public Mango(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Mango");
	}

	@Override
	public void eat() {
		
	}

}
