package space.inventory.resource;

public class OakWood extends Wood{

	public OakWood(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Eichenholz");
	}

}
