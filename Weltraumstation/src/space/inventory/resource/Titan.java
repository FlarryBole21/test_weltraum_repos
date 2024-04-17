package space.inventory.resource;

public class Titan extends Ore{

	public Titan(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public String getType() {
		return "Titan";
	}

	

}
