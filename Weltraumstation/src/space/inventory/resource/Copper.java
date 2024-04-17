package space.inventory.resource;

public class Copper extends Ore{

	public Copper(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public String getType() {
		return "Kupfer";
	}

}
