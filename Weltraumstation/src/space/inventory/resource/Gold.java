package space.inventory.resource;

public class Gold extends Ore{

	public Gold(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Gold");
	}

}
