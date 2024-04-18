package space.inventory.resource;

public class Titan extends Ore{

	public Titan(String name, String quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
		super.setType("Titan");
	}
	
	

}
