package space.inventory.resource;

public class Crystal extends MiningResource {

	public Crystal(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public void degrade() {
		
	}

	@Override
	public void collect() {
		
	}

	@Override
	public String getType() {
		return "Kristall";
	}

	

}
