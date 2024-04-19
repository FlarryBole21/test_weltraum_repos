package space.inventory.resource;

public class WaterMelon extends Fruit{

	private static final long serialVersionUID = 1L;

	public WaterMelon(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Wassermelone");
	}

	@Override
	public void eat() {
		
	}

}
