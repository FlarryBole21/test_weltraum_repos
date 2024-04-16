package space.inventory.resource;

public class ExoticResource extends MiningResource{

	public ExoticResource(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public void degrade() {
		
	}

	@Override
	public void collect() {
		
	}

}
