package space.inventory.resource;

public class TeakWood extends Wood{

	private static final long serialVersionUID = 1L;

	public TeakWood(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Teak-Holz");
	}

}
