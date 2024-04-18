package space.inventory.resource;

public class NormalWood extends Wood{

	public NormalWood(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Normales Holz");
	}

}
