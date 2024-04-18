package space.inventory.resource;

public class Crystal extends MiningResource {

	public Crystal(String name, String quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
		super.setType("Kristall");
	}
	
	
	
}
