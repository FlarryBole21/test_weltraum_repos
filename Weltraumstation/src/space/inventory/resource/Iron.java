package space.inventory.resource;

public class Iron extends Ore{

	public Iron(String name, String quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
		super.setType("Eisen");
	}
	

	
}
