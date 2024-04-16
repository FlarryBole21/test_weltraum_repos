package space.inventory.resource;

public abstract class Ore extends MiningResource{

	public Ore(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public void degrade() {
		
	}

	@Override
	public void collect() {
		
	}

}
