package space.inventory.resource;

public class WillowWood extends Wood{

	private static final long serialVersionUID = 1L;

	public WillowWood(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Weidenholz");
	}

}
