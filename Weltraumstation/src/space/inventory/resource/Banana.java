package space.inventory.resource;

public class Banana extends Fruit{

	public Banana(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Banane");
	}
	
	@Override
	public void eat() {
		
	}


}
