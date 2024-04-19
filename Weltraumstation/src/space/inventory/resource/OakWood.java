package space.inventory.resource;

public class OakWood extends Wood{

	private static final long serialVersionUID = 1L;

	public OakWood(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Eichenholz");
	}

}
